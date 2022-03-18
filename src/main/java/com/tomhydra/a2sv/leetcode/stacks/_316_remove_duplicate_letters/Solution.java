package com.tomhydra.a2sv.leetcode.stacks._316_remove_duplicate_letters;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] letters = new int[26];

        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
        }

        LinkedList<Character> mono = new LinkedList<>();
        Set<Character> seen = new HashSet<>();
        mono.add(s.charAt(0));
        seen.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!seen.contains(c)) {
                while (!mono.isEmpty() && letters[mono.peekLast() - 'a'] > 1 && c <= mono.peekLast()) {
                    char removed = mono.removeLast();
                    letters[removed - 'a']--;
                    seen.remove(removed);
                }
                mono.add(c);
                seen.add(c);
            } else {
                letters[c - 'a']--;
            }

        }

        return mono.stream().map(c -> String.valueOf(c)).collect(Collectors.joining(""));
    }
}