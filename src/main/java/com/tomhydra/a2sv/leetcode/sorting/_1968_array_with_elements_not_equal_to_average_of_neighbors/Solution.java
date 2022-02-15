package com.tomhydra.a2sv.leetcode.sorting._1968_array_with_elements_not_equal_to_average_of_neighbors;

import java.util.Arrays;

class Solution {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length ; i = i + 2) {
            swap(nums, i, i-1);
        }
        return nums;
    }

    private void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}