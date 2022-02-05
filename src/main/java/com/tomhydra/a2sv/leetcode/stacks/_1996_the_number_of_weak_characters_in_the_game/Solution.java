package com.tomhydra.a2sv.leetcode.stacks._1996_the_number_of_weak_characters_in_the_game;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(b[1], a[1]);
            else return Integer.compare(a[0], b[0]);
        });
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < properties.length; i++) {
            while (!stack.isEmpty() && properties[stack.peek()][1] < properties[i][1]) {
                count++;
                stack.pop();
            }
            stack.push(i);
        }
        return count;
    }

}