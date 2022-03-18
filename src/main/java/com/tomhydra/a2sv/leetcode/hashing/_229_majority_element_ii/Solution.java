package com.tomhydra.a2sv.leetcode.hashing._229_majority_element_ii;

import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int maxAppearance = n / 3;
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > maxAppearance) {
                result.add(nums[i]);
            }
        }
        return new ArrayList<>(result);
    }
}