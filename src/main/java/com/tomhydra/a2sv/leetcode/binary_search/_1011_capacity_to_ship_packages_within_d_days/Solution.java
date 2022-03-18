package com.tomhydra.a2sv.leetcode.binary_search._1011_capacity_to_ship_packages_within_d_days;

import java.util.Arrays;

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = Arrays.stream(weights).sum();
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            int calculated = getDays(weights, mid);
            if (calculated > days || calculated == -1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;

    }

    private int getDays(int[] weights, int capacity) {
        int count = 0;
        int days = 1;
        for (int weight : weights) {
            if (weight > capacity) return -1;
            if (count + weight > capacity) {
                days++;
                count = weight;
            } else {
                count += weight;
            }
        }
        return days;
    }
}