package com.tomhydra.a2sv.leetcode.sliding_window._992_subarrays_with_k_different_integers;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        int current = 1;
        int left = 0;
        int right = 0;

        int subarrays = 0;

        while (right < nums.length) {
            count.put(nums[right], count.getOrDefault(nums[right], 0) + 1);
            if (count.size() >= k) {
                if (count.size() > k) {
                    current = 1;
                    // move left until we find a single number
                    while (left < right && count.get(nums[left]) > 1) {
                        count.put(nums[left], count.get(nums[left]) - 1);
                        left++;
                    }
                    count.remove(nums[left]);
                    left++;
                }

                while (left < right && count.get(nums[left]) > 1) {
                    count.put(nums[left], count.get(nums[left]) - 1);
                    left++;
                    current++;

                }

                subarrays += current;
            }
            right++;
        }

        return subarrays;
    }
}