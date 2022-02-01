package com.tomhydra.a2sv.leetcode.arrays._88_merge_sorted_array;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // validate input
        if (nums1 == null || nums2 == null) { throw new IllegalArgumentException("Invalid input"); };

        int first = m - 1, second = n - 1;

        int current = nums1.length - 1;

        // use 'first' and 'second' pointers to compare the elements from right to left
        while (second >= 0) {
            if (first >= 0 && nums2[second] < nums1[first]) {
                nums1[current--] = nums1[first--];
            } else {
                nums1[current--] = nums2[second--];
            }
        }
    }
}