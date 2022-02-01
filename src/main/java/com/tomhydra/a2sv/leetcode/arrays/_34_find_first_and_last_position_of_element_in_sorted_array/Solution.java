package com.tomhydra.a2sv.leetcode.arrays._34_find_first_and_last_position_of_element_in_sorted_array;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;

            // match found, look for matching values left and right
            if (nums[mid] == target) {
                left = mid; right = mid;
                while (left >= 0 && nums[left] == nums[mid]) {
                    left--;
                }
                while (right < nums.length && nums[right] == nums[mid]) {
                    right++;
                }
                return new int[] {left + 1, right - 1};
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return new int[] {-1, -1};
    }
}