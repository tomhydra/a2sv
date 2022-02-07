package com.tomhydra.a2sv.leetcode.stacks._853_car_fleet;

import java.util.Arrays;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int pos = 0;
        int[][] merged = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            merged[i][0] = position[i];
            merged[i][1] = speed[i];
        }
        Arrays.sort(merged, (a, b) -> Integer.compare(b[0], a[0]));

        double slowest = 0;
        int totalFleet = 0;
        for (int[] pair : merged) {
            double remainingTime = (double)(target - pair[0]) / pair[1];
            if (remainingTime <= slowest) {
                continue;
            }
            slowest = remainingTime;
            totalFleet++;

        }
        return totalFleet;

    }

}

