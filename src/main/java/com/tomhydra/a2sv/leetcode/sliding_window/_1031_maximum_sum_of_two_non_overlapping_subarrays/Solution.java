package com.tomhydra.a2sv.leetcode.sliding_window._1031_maximum_sum_of_two_non_overlapping_subarrays;

class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;

        int[] firstSum = new int[n];
        int[] secondSum = new int[n];
        int[] prefixSum = new int[n];

        prefixSum[0] = nums[0];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        firstSum[firstLen-1] = prefixSum[firstLen - 1];
        for (int i = firstLen; i < n; i++) {
            firstSum[i] = prefixSum[i] - prefixSum[i - firstLen];
        }

        secondSum[secondLen-1] = prefixSum[secondLen - 1];
        for (int i = secondLen; i < n; i++) {
            secondSum[i] = prefixSum[i] - prefixSum[i - secondLen];
        }

        int maxSum = 0;
        int leftMax = 0;
        for (int i = firstLen - 1; i < n; i++) {
            // possible left max
            if (i - firstLen + 1 >= secondLen) {
                leftMax = Math.max(leftMax, secondSum[i - firstLen]);
            }
            // possible right max
            int rightMax = 0;
            if (i + secondLen < n) {
                rightMax = secondSum[i + secondLen];
                for (int j = i + secondLen + 1; j < n; j++) {
                    rightMax = Math.max(rightMax, secondSum[j]);
                }
            }

            maxSum = Math.max(maxSum, firstSum[i] + Math.max(leftMax, rightMax));
        }

        return maxSum;
    }
}