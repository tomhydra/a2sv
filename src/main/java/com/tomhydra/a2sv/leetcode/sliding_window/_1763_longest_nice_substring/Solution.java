package com.tomhydra.a2sv.leetcode.sliding_window._1763_longest_nice_substring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public String longestNiceSubstring(String s) {
        Map<Character, Set<Character>> seen;
        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            seen = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                Set<Character> current = seen
                        .getOrDefault(Character.toLowerCase(c), new HashSet<>());
                current.add(c);
                seen.put(Character.toLowerCase(c), current);

                if (isNiceSubstring(seen)) {
                    longest = (j - i + 1) > longest.length() ? s.substring(i, j + 1) : longest;
                }
            }

        }
        return longest;
    }

    private boolean isNiceSubstring(Map<Character, Set<Character>> seen) {
        return seen.values().stream().noneMatch(h -> h.size() < 2);
    }
}