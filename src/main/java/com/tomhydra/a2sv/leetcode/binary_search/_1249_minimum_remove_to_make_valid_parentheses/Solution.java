package com.tomhydra.a2sv.leetcode.binary_search._1249_minimum_remove_to_make_valid_parentheses;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> toRemove = new HashSet<>();
        LinkedList<Integer> openBrackets = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openBrackets.addLast(i);
            } else if (c == ')') {
                if (openBrackets.size() == 0) {
                    toRemove.add(i);
                    continue;
                } else {
                    openBrackets.removeFirst();
                }
            }
        }

        toRemove.addAll(openBrackets);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!toRemove.contains(i)) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}