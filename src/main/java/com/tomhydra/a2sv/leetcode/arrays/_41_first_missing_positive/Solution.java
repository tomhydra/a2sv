package com.tomhydra.a2sv.leetcode.arrays._41_first_missing_positive;

class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean found1 = false;
        for (int num : nums) {
            if (num == 1) {
                found1 = true;
                break;
            }
        }

        if (!found1) return 1;

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] <= 0 || nums[i] > nums.length ? 1 : nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            nums[val - 1] = -1 * Math.abs(nums[val - 1]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;

    }
}