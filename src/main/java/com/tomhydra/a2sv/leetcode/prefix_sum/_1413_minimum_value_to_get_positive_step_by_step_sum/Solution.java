package com.tomhydra.a2sv.leetcode.prefix_sum._1413_minimum_value_to_get_positive_step_by_step_sum;

class Solution {
    public int minStartValue(int[] nums) {
        int[] prefixSum = new int[nums.length];

        prefixSum[0] = nums[0];

        int startValue = 1;
        for (int i = 0; i < nums.length; i++) {
            int prev = i == 0 ? 0 : prefixSum[i-1];
            prefixSum[i] = prev + nums[i];
            if (prefixSum[i] < 0) {
                startValue += -1 * prefixSum[i];
                prefixSum[i] = 0;
            }
        }
        return startValue;
    }
}