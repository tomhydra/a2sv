package com.tomhydra.a2sv.leetcode.sorting._2007_find_original_array_from_doubled_array;

import java.util.*;

class Solution {
    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);

        Map<Integer, Integer> doubles = new HashMap<>();

        List<Integer> found = new ArrayList<>();
        for (int num : changed) {
            if (doubles.containsKey(num)) {
                doubles.put(num, doubles.get(num) - 1);
                if (doubles.get(num) == 0) doubles.remove(num);
                found.add(num / 2);
            } else {
                doubles.put(num * 2, doubles.getOrDefault(num * 2, 0) + 1);
            }
        }

        if (doubles.size() > 0) return new int[0];

        return found.stream().mapToInt(a -> (int)a).toArray();
    }
}