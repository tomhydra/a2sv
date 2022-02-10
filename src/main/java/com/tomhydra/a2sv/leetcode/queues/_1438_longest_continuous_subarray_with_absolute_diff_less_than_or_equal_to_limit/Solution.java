package com.tomhydra.a2sv.leetcode.queues._1438_longest_continuous_subarray_with_absolute_diff_less_than_or_equal_to_limit;

import java.util.LinkedList;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        LinkedList<Integer> queue = new LinkedList<>();

        int minIndex = 0, maxIndex = 0;
        int longest = 0;
        for (int i = 0; i <= nums.length; i++) {
            while (!queue.isEmpty() && nums[maxIndex] - nums[minIndex] > limit) {
                int idx = queue.removeFirst();
                if (idx == maxIndex) {
                    maxIndex = getMaxValue(nums, idx+1, i-1);
                }
                if (idx == minIndex) {
                    minIndex = getMinValue(nums, idx+1, i-1);
                }
            }
            longest = Math.max(longest, queue.size());
            if (i == nums.length) return longest;

            maxIndex = nums[maxIndex] <= nums[i] ? i : maxIndex;
            minIndex = nums[minIndex] >= nums[i] ? i : minIndex;

            queue.addLast(i);
        }
        return longest;
    }


    private int getMaxValue(int[] nums, int start, int end) {
        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] >= nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private int getMinValue(int[] nums, int start, int end) {
        int minIndex = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] <= nums[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}

