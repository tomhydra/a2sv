package com.tomhydra.a2sv.leetcode_self_picked._503_next_greater_element_ii;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int size = nums.length;
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> greater = new HashMap<>();
        for (int i = 0; i < 2 * size; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i%size]) {
                greater.put(stack.pop(), nums[i%size]);
            }
            if (i < size) {
                stack.push(i);
            }

        }
        int[] result = new int[nums.length];
        for (int i = 0; i < size; i++) {
            result[i] = greater.getOrDefault(i, -1);
        }
        return result;
    }
}