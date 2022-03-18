package com.tomhydra.a2sv.leetcode.hashing._12_integer_to_roman;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Roman> romanNumerals;

    public Solution() {
        romanNumerals = initializeRomanNumerals();
    }
    public String intToRoman(int num) {
        int current = num;
        StringBuilder result = new StringBuilder();
        for (int i = romanNumerals.size() - 1; i >= 0; i--) {
            int romanVal = romanNumerals.get(i).val;
            while (current >= romanVal) {
                current -= romanVal;
                result.append(romanNumerals.get(i).label);
            }
        }
        return result.toString();
    }

    private List<Roman> initializeRomanNumerals() {
        List<Roman> numerals = new ArrayList<>();
        numerals.add(new Roman("I", 1));
        numerals.add(new Roman("IV", 4));
        numerals.add(new Roman("V", 5));
        numerals.add(new Roman("IX", 9));
        numerals.add(new Roman("X", 10));
        numerals.add(new Roman("XL", 40));
        numerals.add(new Roman("L", 50));
        numerals.add(new Roman("XC", 90));
        numerals.add(new Roman("C", 100));
        numerals.add(new Roman("CD", 400));
        numerals.add(new Roman("D", 500));
        numerals.add(new Roman("CM", 900));
        numerals.add(new Roman("M", 1000));
        return numerals;
    }

}

class Roman {
    String label;
    int val;
    public Roman(String label, int val) {
        this.label = label;
        this.val = val;
    }
}

