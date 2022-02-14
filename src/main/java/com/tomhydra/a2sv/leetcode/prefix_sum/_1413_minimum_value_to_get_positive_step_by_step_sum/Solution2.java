package com.tomhydra.a2sv.leetcode.prefix_sum._1413_minimum_value_to_get_positive_step_by_step_sum;

public class Solution2 {
    public int minStartValue(int[] nums) {
        int minPositive = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            minPositive = Math.min(minPositive, sum);
        }
        return -minPositive + 1;

    }
}

