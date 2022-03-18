package com.tomhydra.a2sv.leetcode.hashing._273_integer_to_english_words;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private String[] groups = new String[] {"Thousand", "Million", "Billion"};

    private Map<String, String> threeToNine = getThreeToNine();
    private Map<String, String> specialCases = getSpecialCases();
    private Map<String, String> singleDigits = getSingleDigits();

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        String val = String.valueOf(num);
        int len = val.length();

        int firstPart = len % 3;
        int numThousands = len / 3 + (firstPart == 0 ? 0 : 1);

        if (len <= 3) return convertUptoThreeDigit(val).strip();

        int substringLength = firstPart != 0 ? firstPart : 3;
        StringBuilder result = new StringBuilder();
        result.append(convertUptoThreeDigit(val.substring(0, substringLength))).append(" ");
        result.append(groups[numThousands - 2]);
        int index = substringLength;
        for (int i = 1; i < numThousands; i++) {
            String convResult = convertUptoThreeDigit(val.substring(substringLength, substringLength + 3));
            substringLength += 3;
            if (convResult.length() == 0) continue;
            result.append(" " + convResult);
            if (i < numThousands - 1) {
                result.append(" " + groups[numThousands - i - 2]);
            }

        }

        return String.join(" ", result.toString().split("\\s+")).strip() ;

    }

    private String convertUptoThreeDigit(String numString) {
        int num = Integer.parseInt(numString);
        if (num == 0) return "";

        if (numString.length() == 1) {
            return singleDigits.get(numString);
        }

        else if (numString.length() == 2) {
            int firstVal = numString.charAt(0) - '0';
            int secondVal = numString.charAt(1) - '0';
            if (specialCases.containsKey(numString)) {
                return specialCases.get(numString);
            } else {
                if (firstVal == 1) {
                    String teen = threeToNine.get(String.valueOf(secondVal));
                    return teen + "een";
                } else if (firstVal > 1) {
                    String tens = threeToNine.get(String.valueOf(firstVal));
                    tens += "y";
                    if (secondVal > 0) {
                        return tens + " " + singleDigits.get(String.valueOf(secondVal));
                    }
                    return tens;
                }
                return singleDigits.get(String.valueOf(secondVal));
            }
        } else {
            int firstVal = numString.charAt(0) - '0';
            StringBuilder result = new StringBuilder();
            if (firstVal > 0) {
                result.append(singleDigits.get(String.valueOf(firstVal))).append(" ");
                result.append("Hundred").append(" ");
                result.append(convertUptoThreeDigit(numString.substring(1, 3)));
                return result.toString();

            } else {
                return convertUptoThreeDigit(numString.substring(1, 3));
            }
        }
    }

    private Map<String, String> getSingleDigits() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "One");
        map.put("2", "Two");
        map.put("3", "Three");
        map.put("4", "Four");
        map.put("5", "Five");
        map.put("6", "Six");
        map.put("7", "Seven");
        map.put("8", "Eight");
        map.put("9", "Nine");
        return map;
    }

    private Map<String, String> getThreeToNine() {
        Map<String, String> map = new HashMap<>();
        map.put("2", "Twent");
        map.put("3", "Thirt");
        map.put("4", "Fort");
        map.put("5", "Fift");
        map.put("6", "Sixt");
        map.put("7", "Sevent");
        map.put("8", "Eight");
        map.put("9", "Ninet");
        return map;
    }

    private Map<String, String> getSpecialCases() {
        Map<String, String> map = new HashMap<>();
        map.put("10", "Ten");
        map.put("11", "Eleven");
        map.put("12", "Twelve");
        map.put("14", "Fourteen");
        return map;
    }
}