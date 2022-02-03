package com.tomhydra.a2sv.leetcode.stacks._496_next_greater_element_i;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> mstack = new Stack<>();
        Map<Integer, Integer> greater = new HashMap<>();
        for (int num : nums2) {
            while (!mstack.isEmpty() && mstack.peek() < num) {
                greater.put(mstack.pop(), num);
            }
            mstack.push(num);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = greater.getOrDefault(nums1[i], -1);
        }

        return result;
    }
}