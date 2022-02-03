package com.tomhydra.a2sv.leetcode.stacks._739_daily_temperatures;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> mStack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!mStack.isEmpty() && temperatures[mStack.peek()] < temperatures[i]) {
                int idx = mStack.pop();
                map.put(idx, i - idx);
            }
            mStack.push(i);
        }

        int[] result = new int[temperatures.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = map.getOrDefault(i, 0);
        }
        return result;
    }
}
