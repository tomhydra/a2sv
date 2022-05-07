package com.tomhydra.a2sv.leetcode.heaps._347_top_k_frequent_elements;

import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            minHeap.add(new int[] {entry.getKey(), entry.getValue()});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] result = new int[minHeap.size()];
        int count = 0;
        while (count < result.length) {
            result[count] = minHeap.poll()[0];
            count++;
        }
        return result;
    }
}