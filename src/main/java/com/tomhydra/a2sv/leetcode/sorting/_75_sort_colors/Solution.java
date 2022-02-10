package com.tomhydra.a2sv.leetcode.sorting._75_sort_colors;

class Solution {
    private final int RED = 0, WHITE = 1, BLUE = 2;
    public void sortColors(int[] nums) {
        int red  = 0, white = 0, blue = nums.length - 1;

        while (white <= blue) {
            if (nums[white] == BLUE) {
                swap(nums, white, blue);
                blue--;
            } else if (nums[white] == RED) {
                swap(nums, white, red);
                red++;
                white++;
            } else {
                white++;
            }

        }
    }

    private void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}