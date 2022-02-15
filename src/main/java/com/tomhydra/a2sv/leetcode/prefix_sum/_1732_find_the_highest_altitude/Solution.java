package com.tomhydra.a2sv.leetcode.prefix_sum._1732_find_the_highest_altitude;

class Solution {
    public int largestAltitude(int[] gain) {
        int prev = 0;
        int max = prev;
        for (int i = 0; i < gain.length; i++) {
            prev += gain[i];
            max = Math.max(prev, max);
        }
        return max;
    }
}