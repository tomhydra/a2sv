package com.tomhydra.a2sv.utils.solution_file_automation;

import org.apache.commons.io.FileUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolutionFileManager {
    private final String LEETCODE_URL = "https://leetcode.com";
    private final String REQUEST_BASE_URL =  LEETCODE_URL + "/graphql";

    private final String SOLUTION_BASE_PATH = "";

    public static void main(String[] args) throws IOException {
        SolutionFileManager manager = new SolutionFileManager();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter cookie (cookie is needed to download submissions)");
        String cookie = scanner.nextLine();
        System.out.println("Enter problem url and type separated by space. " +
                "You can add multiple of them in different lines. " +
                "Press 'enter' twice to stop the process.");
        String read = scanner.nextLine();
        Map<String, List<String>> readmeData = new HashMap<>();
        while (!read.isEmpty()) {
            String[] parts = read.split(" ", 2);
            String titleSlug = manager.parseTitleSlug(parts[0]);
            String type = parts[1];
            String slugifiedType = type.toLowerCase().replaceAll(" ", "_");
            Problem problem = manager.fetchProblemInformation(parts[0],titleSlug, slugifiedType);
            Solution solution = manager.fetchSolution(titleSlug, cookie);
            solution.setProblem(problem);
            manager.createSolutionFile(problem, solution);
            String currentReadmeData = manager.prepareForReadme(problem, solution.getSolutionFileName());
            readmeData.computeIfAbsent(type, k -> new ArrayList<>()).add(currentReadmeData);
            System.out.println(currentReadmeData);
            read = scanner.nextLine();
        }
        manager.updateReadmeFile(readmeData);
    }

    public void updateReadmeFile(Map<String, List<String>> newReadmeData) throws IOException {
        File readmeFile = new File("README.md");
        String readmeText = FileUtils.readFileToString(readmeFile, "utf-8");

        for (Map.Entry<String, List<String>> entry : newReadmeData.entrySet()) {
            Pattern pattern = Pattern.compile("#### " + entry.getKey() + "\\n([ \\S]+\\n)*");
            Matcher matcher = pattern.matcher(readmeText);
            String solutionRows = String.join("\n", entry.getValue()) + "\n";
            if (matcher.find()) {
                readmeText = readmeText.substring(0, matcher.end()) + solutionRows + readmeText.substring(matcher.end());
            } else {
                String header = "\n#### " + entry.getKey() + "\n" +
                        "| ID | Name | Difficulty | Solutions |\n" +
                        "|----|------|------------|-----------|\n";
                readmeText += header + solutionRows;
            }
            FileUtils.writeStringToFile(readmeFile, readmeText, "utf-8");
        }
    }

    public Problem fetchProblemInformation(String problemUrl, String titleSlug, String type) {
        Problem problem = new Problem();
        problem.setLink(problemUrl);
        problem.setType(type);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(requestBody(titleSlug)))
                .header("Content-Type", "application/json")
                .uri(URI.create(REQUEST_BASE_URL)).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(data -> updateProblem(problem, data))
                .join();
        return problem;
    }

    public void createSolutionFile(Problem problem, Solution solution) throws IOException {
        File directory = new File(problem.getParentDirectory());
        if (!directory.exists()) {
            directory.mkdirs();
        }

        Matcher className = Pattern.compile("class \\w+").matcher(solution.getSolutionCode());
        String solutionFileName = "Solution";
        if (className.find()) {
            solutionFileName = className.group().replace("class ", "");
        }
        solution.setSolutionFileName(solutionFileName);
        File solutionFile = new File(problem.getParentDirectory() + solutionFileName + ".java");
        if (!solutionFile.exists()) {
            solutionFile.createNewFile();
        }

        try (FileWriter writer = new FileWriter(solutionFile.getAbsoluteFile())) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
                bufferedWriter.write(getUpdatedSolutionData(problem, solution.getSolutionCode()));
            }
        }
    }

    public String getUpdatedSolutionData(Problem problem, String solution) {
        String packageName = String.format("com.tomhydra.a2sv.leetcode.%s._%d_%s",
                problem.getType(), problem.getNumber(), problem.getSlug());

        return "package " + packageName + ";\n\n" +
                "import java.util.*;\n\n" +
                "public " + solution;

    }

    public String prepareForReadme(Problem problem, String solutionFileName) {
        return String.format("| %d | [%s](%s) | %s | [Solution](%s) |" ,
                problem.getNumber(), problem.getName(), problem.getLink(), problem.getDifficulty(), problem.getParentDirectory() + solutionFileName + ".java"
                );
    }

    private String requestBody(String titleSlug) {
        return "{\"operationName\":\"questionData\",\"variables\":{\"titleSlug\":\"" + titleSlug + "\"},\"query\":\"query questionData($titleSlug: String!) {\\n  question(titleSlug: $titleSlug) {\\n    questionId\\n    questionFrontendId\\n     title\\n    titleSlug\\n   difficulty\\n }\\n}\\n\"}";
    }

    public String parseTitleSlug(String problemUrl) {
        String[] parts = problemUrl.split("/");
        return parts[parts.length - 1];
    }

    private void updateProblem(Problem problem, String data) {
        if (problem == null) return;
        JSONObject questionObject = (new JSONObject(data)).getJSONObject("data").getJSONObject("question");
        problem.setDifficulty(DifficultyType.valueOf(questionObject.getString("difficulty").toUpperCase()));
        problem.setName(questionObject.getString("title"));
        problem.setNumber(Integer.parseInt(questionObject.getString("questionFrontendId")));
        problem.setSlug(questionObject.getString("titleSlug").replaceAll("-","_"));
    }

    public Solution fetchSolution(String titleSlug, String cookie) {
        Solution solution = new Solution();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .header("Cookie", cookie)
                .header("Referer", "https://leetcode.com/problems/" + titleSlug +"/submissions/")
                .uri(URI.create("https://leetcode.com/api/submissions/" + titleSlug + "/")).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(data -> {
                    JSONArray submissions = (new JSONObject(data))
                            .getJSONArray("submissions_dump");
                    for (int i = 0; i < submissions.length(); i++) {
                        var current = submissions.getJSONObject(i);
                        var status = current.getString("status_display");
                        if (status.equals("Accepted")) {
                            solution.setSolutionCode(StringEscapeUtils.unescapeJava(current.getString("code")));
                            break;
                        }
                    }
                })
                .join();
        return solution;
    }
}

