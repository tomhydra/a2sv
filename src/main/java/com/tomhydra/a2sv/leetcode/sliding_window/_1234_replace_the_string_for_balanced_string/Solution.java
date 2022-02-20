package com.tomhydra.a2sv.leetcode.sliding_window._1234_replace_the_string_for_balanced_string;

import java.util.HashMap;
import java.util.Map;

class Solution {
    int totalLetters = 4;
    public int balancedString(String s) {
        Map<Character, Integer> seen = new HashMap<>();
        Map<Character, Integer> toRemove = new HashMap<>();
        int len = s.length();

        for (char c : s.toCharArray()) {
            seen.put(c, seen.getOrDefault(c, 0) + 1);
        }

        int perType = len / totalLetters;
        for (Map.Entry<Character, Integer> entry : seen.entrySet()) {
            if (entry.getValue() > perType) {
                toRemove.put(entry.getKey(), entry.getValue() - perType);
            }
        }

        if (toRemove.size() == 0) return 0;

        int left = 0;
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i <= len; i++) {

            if (hasValidSubstring(toRemove)) {
                char l = s.charAt(left);
                while (left < i && (!toRemove.containsKey(l) || toRemove.get(l) < 0)) {
                    // remove if found
                    if (toRemove.containsKey(l)) toRemove.put(l, toRemove.get(l) + 1);
                    left++;
                    l = s.charAt(left);
                }
                // update shortest substring
                shortest = Math.min(shortest, i - left);

                // remove left letter since it is already counted
                if (toRemove.containsKey(l)) {
                    toRemove.put(l, toRemove.get(l) + 1);
                    left++;
                }

            }
            if (i == len) break;

            char c = s.charAt(i);

            if (toRemove.containsKey(c)) {
                toRemove.put(c, toRemove.get(c) - 1);
            }
        }


        return shortest;
    }

    private boolean hasValidSubstring(Map<Character, Integer> toRemove) {
        return !toRemove.values().stream().anyMatch(i -> i > 0);
    }
}