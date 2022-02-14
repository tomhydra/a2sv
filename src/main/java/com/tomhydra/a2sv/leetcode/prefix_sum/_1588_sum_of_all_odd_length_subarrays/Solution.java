package com.tomhydra.a2sv.leetcode.prefix_sum._1588_sum_of_all_odd_length_subarrays;

class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int[] prefixSum = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int prev = i == 0 ? 0 : prefixSum[i-1];
            prefixSum[i] = prev + arr[i];
        }
        int n = arr.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (j - i % 2 == 0) {
                    int prev = i == 0 ? 0 : prefixSum[i-1];
                    total += prefixSum[j] - prev;
                }
            }
        }
        return total;
    }
}