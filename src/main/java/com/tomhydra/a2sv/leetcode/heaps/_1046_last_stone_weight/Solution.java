package com.tomhydra.a2sv.leetcode.heaps._1046_last_stone_weight;

import java.util.*;

public class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 0) return 0;
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        
        for (int stone : stones) {
            maxHeap.add(stone);
        }
        int first = 0, second = 0; // early initialization
        while (maxHeap.size() > 1) {
            first = maxHeap.poll();
            second = maxHeap.poll();
            if (first != second) {
                maxHeap.add(first - second);
            }
        }
        return maxHeap.size() == 0 ? 0 : maxHeap.poll();
    }
}