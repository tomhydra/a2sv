package com.tomhydra.a2sv.leetcode.binary_search._287_find_the_duplicate_number;

class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int current = Math.abs(nums[i]);
            if (nums[current - 1] < 0) return current;
            nums[current - 1] *= -1;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        throw new IllegalArgumentException("No duplicates!");
    }
}