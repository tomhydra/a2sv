package com.tomhydra.a2sv.leetcode.dp._198_house_robber;

import java.util.*;

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int first = nums[0];
        int second = Math.max(first, nums[1]);
        int current = 0;
        for (int i = 2; i < nums.length; i++) {
            current = Math.max(nums[i] + first, second);
            first = second;
            second = current;
        }
        return second;
    }
}