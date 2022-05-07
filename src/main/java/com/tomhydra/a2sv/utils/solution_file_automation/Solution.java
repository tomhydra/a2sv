package com.tomhydra.a2sv.utils.solution_file_automation;

public class Solution {
    private Problem problem;
    private String solutionCode;
    private String solutionFileName;

    public Solution() {
    }

    public Solution(Problem problem, String solutionCode, String solutionFileName) {
        this.problem = problem;
        this.solutionCode = solutionCode;
        this.solutionFileName = solutionFileName;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public String getSolutionCode() {
        return solutionCode;
    }

    public void setSolutionCode(String solutionCode) {
        this.solutionCode = solutionCode;
    }

    public String getSolutionFileName() {
        return solutionFileName;
    }

    public void setSolutionFileName(String solutionFileName) {
        this.solutionFileName = solutionFileName;
    }
}
