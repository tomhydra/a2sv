package com.tomhydra.a2sv.leetcode.queues._560_subarray_sum_equal_k;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) total++;
            int sum = nums[nums.length - i - 1];
            for (int j = nums.length - i - 2; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    total++;
                }
            }
        }
        return total;
    }
}