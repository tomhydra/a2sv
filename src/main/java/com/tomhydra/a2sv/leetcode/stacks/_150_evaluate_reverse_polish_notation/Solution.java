package com.tomhydra.a2sv.leetcode.stacks._150_evaluate_reverse_polish_notation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
    Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
    public int evalRPN(String[] tokens) {
        Stack<Integer> rpnStack = new Stack<>();
        for (String token : tokens) {
            if (operators.contains(token)) {
                int second = rpnStack.pop();
                int first = rpnStack.pop();
                int result = applyOperator(first, second, token);
                rpnStack.push(result);
            } else {
                rpnStack.push(Integer.parseInt(token));
            }
        }
        return rpnStack.pop();
    }

    private int applyOperator(int first, int second, String operator) {
        switch (operator) {
            case "*":
                return first * second;
            case "/":
                return first / second;
            case "-":
                return first - second;
            case "+":
                return first + second;
            default:
                throw new IllegalArgumentException("Unrecognized operator!");
        }
    }
}