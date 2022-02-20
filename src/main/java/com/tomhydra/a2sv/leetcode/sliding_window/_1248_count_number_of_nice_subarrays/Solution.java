package com.tomhydra.a2sv.leetcode.sliding_window._1248_count_number_of_nice_subarrays;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int left = 0, right = 0;
        int total = 0;
        int len = nums.length;
        while (right < nums.length) {
            if (nums[right] % 2 == 1) {
                count++;
                if (count >= k) {
                    int leftCount = 1;
                    while (nums[left] % 2 == 0) {
                        left++;
                        leftCount++;
                    }
                    left++;

                    int rightCount = 1;
                    right++;
                    while (right < len && nums[right] % 2 == 0) {
                        right++;
                        rightCount++;
                    }
                    total += leftCount * rightCount;
                    count--;
                } else {right++; }
            } else { right++; }
        }
        return total;
    }
}