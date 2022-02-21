package com.tomhydra.a2sv.leetcode.sliding_window._3_longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> seen = new HashMap<>();

        int left = 0, right = 0;

        int longest = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (seen.containsKey(c)) {
                longest = Math.max(longest, right - left);

                int nextValid = seen.get(c) + 1; // character after the duplicate

                while (left < nextValid) {
                    seen.remove(s.charAt(left));
                    left++;
                }
            }
            seen.put(c, right);
            right++;
        }

        return Math.max(right - left, longest);
    }
}