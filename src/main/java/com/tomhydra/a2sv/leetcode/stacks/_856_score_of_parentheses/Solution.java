package com.tomhydra.a2sv.leetcode.stacks._856_score_of_parentheses;

import java.util.LinkedList;

class Solution {
    public int scoreOfParentheses(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (c == ')') {
                char last = stack.removeLast();
                int newScore = 1;

                if (last != '(') { // is a number
                    stack.removeLast(); // remove next '('
                    newScore = 2 * (last - '0');
                }

                // combine neighboring scores
                while (!stack.isEmpty() && stack.getLast() != '(') {
                    newScore += stack.removeLast() - '0';
                }

                stack.addLast((char)(newScore + '0'));

            } else {
                stack.addLast(c);
            }
        }

        return stack.removeLast() - '0';
    }

}