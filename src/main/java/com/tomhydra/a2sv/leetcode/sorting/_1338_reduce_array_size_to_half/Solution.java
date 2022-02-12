package com.tomhydra.a2sv.leetcode.sorting._1338_reduce_array_size_to_half;

import java.util.*;

class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : arr) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(count.entrySet());
        Collections.sort(entries, Map.Entry.comparingByValue(Comparator.reverseOrder()));

        int untilNow = 0;
        int total = 0;
        int halfSize = arr.length / 2;
        for (Map.Entry<Integer, Integer> entry : entries) {
            untilNow += entry.getValue();
            total += 1;
            if (untilNow >= halfSize) return total;

        }
        return total;
    }
}