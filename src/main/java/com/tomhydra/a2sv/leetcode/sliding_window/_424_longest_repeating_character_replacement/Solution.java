package com.tomhydra.a2sv.leetcode.sliding_window._424_longest_repeating_character_replacement;

class Solution {
    public int characterReplacement(String s, int k) {
        int longest = 1;
        int len = s.length();

        for (int i = 0; i < 26; i++) {
            char c = (char)('A' + i);
            int remaining = k;
            int left = 0, right = 0;
            for (int j = 0; j < len; j++) {
                if (s.charAt(j) != c) {
                    // check if not possible anymore
                    if (remaining <= 0) {
                        while (left < j && s.charAt(left) == c) {
                            left++;
                        }
                        left++; // skip the left most invalid char
                    } else {
                        remaining--;
                    }
                }
                longest = Math.max(longest, j - left + 1);
            }
        }
        return longest;
    }
}