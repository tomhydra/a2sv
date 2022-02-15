package com.tomhydra.a2sv.leetcode.sorting._1561_maximum_number_of_coins_you_can_get;

import java.util.Arrays;

class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int max = 0;
        int maxAmount = piles.length / 3;
        for (int i = piles.length - 2; i >= maxAmount; i = i - 2) {
            max += piles[i];
        }
        return max;
    }
}