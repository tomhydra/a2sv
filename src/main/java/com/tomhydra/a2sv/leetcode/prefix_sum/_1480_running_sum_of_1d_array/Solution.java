package com.tomhydra.a2sv.leetcode.prefix_sum._1480_running_sum_of_1d_array;

class Solution {
    public int[] runningSum(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        int[] runningSum = new int[nums.length];

        runningSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            runningSum[i] = runningSum[i-1] + nums[i];
        }

        return runningSum;

    }
}