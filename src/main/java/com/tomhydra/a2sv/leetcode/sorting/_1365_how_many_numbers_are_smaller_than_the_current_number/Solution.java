package com.tomhydra.a2sv.leetcode.sorting._1365_how_many_numbers_are_smaller_than_the_current_number;

class Solution {
    private final int BUCKET_SIZE = 101;
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[BUCKET_SIZE];
        int[] result = new int[nums.length];

        for (int num : nums) {
            count[num]++;
        }

        int prev = 0;
        for (int i = 1; i < count.length; i++) {
            int current = count[i-1] + prev;
            prev = count[i];
            count[i] = current;
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] == 0 ? 0 : count[nums[i]];
        }

        return result;
    }
}
