package com.tomhydra.a2sv.leetcode.stacks._20_valid_parentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    private Map<Character, Character> map;

    public Solution() {
        map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
    }

    public boolean isValid(String s) {
        Stack stack = new Stack();
        for (char parentheses : s.toCharArray()) {
            if (map.containsKey(parentheses)) {
                stack.push(parentheses);
            } else if (!stack.isEmpty() && map.get(stack.peek()) == parentheses) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.size() == 0;
    }
}
