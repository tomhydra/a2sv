package com.tomhydra.a2sv.leetcode.heaps._1642_furthest_building_you_can_reach;

import java.util.*;

public class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int gap = 0;
        for (int i = 1; i < heights.length; i++) {
            gap = heights[i] - heights[i-1];
            if (gap > 0) {
                if (ladders > 0) {
                    heap.add(gap);
                    ladders--;
                } else if (bricks > 0) {
                    if (!heap.isEmpty() && heap.peek() < gap) {
                        bricks -= heap.poll();
                        heap.add(gap);              
                    } else {
                        bricks -= gap;
                    }
                    if (bricks < 0) return i -1;
                } else {
                    return i - 1;
                }
            }
        }
        return heights.length - 1;
    }
}