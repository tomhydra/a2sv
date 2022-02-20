package com.tomhydra.a2sv.leetcode.prefix_sum._528_random_pick_with_weight;

class Solution {
    int[] w;
    int[] prefixSum;

    public Solution(int[] w) {
        this.w = w;
        this.prefixSum = new int[w.length];

        prefixSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }

    }

    public int pickIndex() {
        double rand = Math.random() * prefixSum[prefixSum.length - 1];

        for (int i = 0; i < prefixSum.length; i++) {
            if (rand < prefixSum[i]) return i;
        }
        return w.length - 1;
    }

}
