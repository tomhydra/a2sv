package com.tomhydra.a2sv.leetcode.sorting._1859_sorting_the_sentence;

import java.util.Arrays;

class Solution {
    public String sortSentence(String s) {
        String[] parts = s.split(" ");
        Arrays.sort(parts, (a, b) -> (a.charAt(a.length() - 1) - '0') - (b.charAt(b.length() - 1) - '0'));

        StringBuilder result = new StringBuilder();
        for (String part : parts) {
            result.append(part.substring(0, part.length() - 1)).append(" ");
        }
        return result.toString().trim();
    }
}