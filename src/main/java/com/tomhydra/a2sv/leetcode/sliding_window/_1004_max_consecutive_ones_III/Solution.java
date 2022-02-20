package com.tomhydra.a2sv.leetcode.sliding_window._1004_max_consecutive_ones_III;

class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int maxPossible = 0;
        int flipped = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                if (flipped >= k) {
                    while (nums[left] == 1) {
                        left++;
                    }
                    left++;
                } else {
                    flipped++;
                }
            }

            maxPossible = Math.max(maxPossible, right - left + 1);
            right++;
        }
        return maxPossible;
    }
}