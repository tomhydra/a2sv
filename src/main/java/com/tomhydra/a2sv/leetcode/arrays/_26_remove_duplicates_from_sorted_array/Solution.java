package com.tomhydra.a2sv.leetcode.arrays._26_remove_duplicates_from_sorted_array;

class Solution {
    public int removeDuplicates(int[] nums) {
        // validate input
        if (nums == null) throw new IllegalArgumentException("Input cannot be null");
        if (nums.length < 2) return nums.length;
        int left = 0, right = 1;
        while (right < nums.length) {
            while (right < nums.length && nums[left] == nums[right]) {
                right++;
            }
            if (right < nums.length) {
                nums[++left] = nums[right++];
            }
        }
        return left + 1;
    }
}