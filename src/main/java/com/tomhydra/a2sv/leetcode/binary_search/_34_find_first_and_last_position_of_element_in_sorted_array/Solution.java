package com.tomhydra.a2sv.leetcode.binary_search._34_find_first_and_last_position_of_element_in_sorted_array;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[] {-1, -1};
        return new int[] {getIndex(nums, target, true), getIndex(nums, target, false)};
    }

    private int getIndex(int[] nums, int target, boolean isStart) {

        if (isStart && nums[0] == target) return 0;
        if (!isStart && nums[nums.length - 1] == target) return nums.length - 1;

        int left = 0, right = nums.length - 1, mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (isStart) {
                if (nums[mid] < target) {
                    if (mid < nums.length - 1 && nums[mid + 1] == target) {
                        return mid + 1;
                    }
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] > target) {
                    if (mid > 0 && nums[mid - 1] == target) {
                        return mid - 1;
                    }
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}