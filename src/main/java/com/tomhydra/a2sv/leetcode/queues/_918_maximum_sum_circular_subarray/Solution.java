package com.tomhydra.a2sv.leetcode.queues._918_maximum_sum_circular_subarray;

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException("Not a valid input!");
        int val = nums[0];
        int curMin = val, curMax = val;
        int minSum = val, maxSum = val;
        int total = val;

        for (int i = 1; i < nums.length; i++) {
            curMin = Math.min(curMin + nums[i], nums[i]);
            minSum = Math.min(curMin, minSum);
            curMax = Math.max(curMax + nums[i], nums[i]);
            maxSum = Math.max(curMax, maxSum);
            total += nums[i];
        }

        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}
