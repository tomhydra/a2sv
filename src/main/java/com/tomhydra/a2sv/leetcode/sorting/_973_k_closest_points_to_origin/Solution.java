package com.tomhydra.a2sv.leetcode.sorting._973_k_closest_points_to_origin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        List<Pair> pointsWithDistance = new ArrayList<>();
        for (int[] point : points) {
            pointsWithDistance.add(new Pair(point));
        }

        Collections.sort(pointsWithDistance, Comparator.comparingDouble(a -> a.distance));

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = pointsWithDistance.get(i).point;
        }

        return result;
    }
}

class Pair {
    public double distance = 0;
    public int[] point;

    public Pair(int[] point) {
        distance = Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
        this.point = point;
    }
}