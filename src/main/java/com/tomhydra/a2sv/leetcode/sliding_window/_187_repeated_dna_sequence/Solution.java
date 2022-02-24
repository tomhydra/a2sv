package com.tomhydra.a2sv.leetcode.sliding_window._187_repeated_dna_sequence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private final int SEQUENCE_LENGTH = 10;
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> hash = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (int i = 0; i < s.length() - SEQUENCE_LENGTH + 1; i++) {
            String current = s.substring(i, i + SEQUENCE_LENGTH);
            if (hash.contains(current)) {
                result.add(current);
            } else {
                hash.add(current);
            }
        }

        return new ArrayList<>(result);
    }
}
