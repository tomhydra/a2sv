package com.tomhydra.a2sv.leetcode.prefix_sum._209_minimum_size_subarray_sum;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];

        for (int i = 0; i < n; i++) {
            int prev = i == 0 ? 0: prefixSum[i-1];
            prefixSum[i] = prev + nums[i];
        }

        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int prev = i == 0 ? 0 : prefixSum[i-1];
            for (int j = i; j < n; j++) {
                if (prefixSum[j] - prev >= target) {
                    int length = j - i + 1;
                    minLength = Math.min(minLength, length);
                    break; // we have found the minimum for the current iteration
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}