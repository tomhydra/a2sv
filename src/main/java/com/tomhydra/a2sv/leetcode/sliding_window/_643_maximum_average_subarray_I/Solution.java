package com.tomhydra.a2sv.leetcode.sliding_window._643_maximum_average_subarray_I;

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double maxAverage = sum / k;

        int left = 0, right = k;
        double average = 0;
        while (right < nums.length) {
            sum += nums[right] - nums[left];
            average = sum / k;
            maxAverage = Math.max(average, maxAverage);
            left++;
            right++;
        }
        return maxAverage;
    }
}