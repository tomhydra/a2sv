package com.tomhydra.a2sv.leetcode.arrays._53_maximum_subarray;

class Solution {
    public int maxSubArray(int[] nums) {
        // validate input
        if (nums == null || nums.length < 1) throw new IllegalArgumentException("Invalid input");

        int current = nums[0], max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            current = Math.max(current + nums[i], nums[i]);
            max = Math.max(current, max);
        }

        return max;
    }
}