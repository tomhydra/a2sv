package com.tomhydra.a2sv.leetcode.sliding_window._219_contains_duplicate_II;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) return false;
        k = k >= nums.length ? nums.length - 1 : k;
        Set<Integer> seen = new HashSet<>();
        int left = 0, right = 0;
        while (right < left + k) {
            if (seen.contains(nums[right])) {
                return true;
            }
            seen.add(nums[right]);
            right++;
        }
        while (right < nums.length) {
            if (seen.contains(nums[right])) {
                return true;
            }
            seen.remove(nums[left]);
            seen.add(nums[right]);
            left++;
            right++;
        }
        return false;
    }
}