package com.tomhydra.a2sv.leetcode.prefix_sum._724_find_pivot_index;

class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;

        int[] prefixSum = new int[nums.length];

        for (int i = 0; i < n; i++) {
            int prev = i == 0 ? 0 : prefixSum[i-1];
            prefixSum[i] = prev + nums[i];
        }

        int index = -1;
        for (int i = -1; i < n -1; i++) {
            int current = i == -1 ? 0 : prefixSum[i];
            if (current == prefixSum[n - 1] - prefixSum[i+1]) {
                index = i + 1;
                break;
            }
        }
        return index;
    }
}