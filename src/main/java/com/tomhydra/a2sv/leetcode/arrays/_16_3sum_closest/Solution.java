package com.tomhydra.a2sv.leetcode.arrays._16_3sum_closest;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        Integer closestSum = null;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                closestSum = twoSum(nums, i, target, closestSum);

                if (closestSum == target) return target; // exact value found
            }
        }
        return closestSum;
    }

    private int twoSum(int[] nums, int index, int target, Integer prevSum) {
        int left = index + 1, right = nums.length - 1, sum = 0;
        Integer closestSum = prevSum;
        while (left < right) {
            sum = nums[index] + nums[left] + nums[right];
            closestSum = getSmallest(closestSum, sum, target);
            if (sum == target) return sum;

            if (sum > target) {
                right--;
            } else {
                left++;
            }

        }
        return closestSum;
    }

    private int getSmallest(Integer closestSum, int newSum, int target) {
        if (closestSum == null) return newSum;
        if ((Math.abs(closestSum - target) > Math.abs(newSum - target))) return newSum;
        return closestSum;
    }
}