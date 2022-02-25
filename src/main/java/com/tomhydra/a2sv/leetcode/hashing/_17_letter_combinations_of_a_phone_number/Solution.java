package com.tomhydra.a2sv.leetcode.hashing._17_letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private static Map<Character, String> map;

    static {
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        letterCombinations(digits, 0, "", result);
        return result;
    }

    private void letterCombinations(String digits, int index, String current, List<String> result) {
        if (index >= digits.length()) {
            result.add(current);
            return;
        }
        if (!map.containsKey(digits.charAt(index))) return;
        String numbers = map.get(digits.charAt(index));
        for (int i = 0 ; i < numbers.length(); i++) {
            char c = numbers.charAt(i);
            letterCombinations(digits, index + 1, current + c, result);
        }

    }
}