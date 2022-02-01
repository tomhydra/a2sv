package com.tomhydra.a2sv.leetcode.arrays._15_3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                twoSum(nums, i, result);
            }
        }
        return result;
    }

    private void twoSum(int[] nums, int index, List<List<Integer>> result) {
        int target = nums[index];
        int left = index + 1, right = nums.length - 1;

        while (left < right) {
            int sum = target + nums[left] + nums[right];
            if (sum == 0) {
                result.add(Arrays.asList(target, nums[left++], nums[right--]));
                // skip any duplicates
                while (left > 0 && left < right && nums[left] == nums[left - 1]) left++;
            }
            else if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
    }
}