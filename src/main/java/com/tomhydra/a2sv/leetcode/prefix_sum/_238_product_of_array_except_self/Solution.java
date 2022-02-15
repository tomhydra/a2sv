package com.tomhydra.a2sv.leetcode.prefix_sum._238_product_of_array_except_self;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] rightToLeft = new int[nums.length];
        for (int i = n - 1; i >= 0; i--) {
            int prev = i == (n -1) ? 1 : rightToLeft[i+1];
            rightToLeft[i] = prev * nums[i];
        }

        int product = 1;
        for (int i = 0; i < n; i++) {
            int next = (i == n-1) ? 1 : rightToLeft[i+1];
            int current = nums[i];
            nums[i] = product * next;
            product *= current;
        }

        return nums;
    }
}