package com.tomhydra.a2sv.leetcode.binary_search._33_search_in_rotated_sorted_array;

class Solution {
    public int search(int[] nums, int target) {
        // validate input
        if (nums == null) throw new IllegalArgumentException("nums cannot be null");

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            if (nums[mid] >= nums[left]) { // left part is sorted
                if (target >= nums[left] && target < nums[mid])  {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }

        return -1;


    }


}