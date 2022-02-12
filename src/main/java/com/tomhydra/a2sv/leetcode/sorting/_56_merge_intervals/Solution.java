package com.tomhydra.a2sv.leetcode.sorting._56_merge_intervals;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < intervals.length; i++) {
            minHeap.add(intervals[i]);
        }
        List<int[]> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();

            if (result.size() == 0) {
                result.add(current);
            } else {
                if (result.get(result.size() - 1)[1] >= current[0]) {
                    result.get(result.size() - 1)[1] = Math.max(current[1],result.get(result.size() - 1)[1]);
                } else {
                    result.add(current);
                }
            }
        }
        return result.toArray(new int[0][2]);
    }
}