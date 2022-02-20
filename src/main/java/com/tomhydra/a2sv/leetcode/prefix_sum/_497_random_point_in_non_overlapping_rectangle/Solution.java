package com.tomhydra.a2sv.leetcode.prefix_sum._497_random_point_in_non_overlapping_rectangle;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Solution {
    Map<Integer, int[]> areas;
    int[] sorted;
    int[] prefixSum;
    Random rand;
    int totalArea = 0;

    public Solution(int[][] rects) {
        areas = new HashMap<>();
        rand = new Random();
        prefixSum = new int[rects.length];
        for (int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];
            int area = calculateArea(rect);
            totalArea += area;
            prefixSum[i] += totalArea;
            areas.put(totalArea, rect);
        }
    }

    private int calculateArea(int[] rect) {
        return (rect[3] - rect[1] + 1) * (rect[2] - rect[0] + 1);
    }

    public int[] pick() {
        int random = rand.nextInt(totalArea);
        for (int i = 0; i < prefixSum.length - 1; i++) {
            int pr = prefixSum[i];
            if (random < pr) {
                return pickFromRects(areas.get(pr));

            }
        }
        return pickFromRects(areas.get(prefixSum[prefixSum.length - 1]));
    }

    private int[] pickFromRects(int[] rect) {
        int randomX = rect[0] + rand.nextInt(rect[2] - rect[0] + 1);
        int randomY = rect[1] + rand.nextInt(rect[3] - rect[1] + 1);
        return new int[] {randomX, randomY};

    }
}
