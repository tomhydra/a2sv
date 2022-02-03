package com.tomhydra.a2sv.leetcode.stacks._121_best_time_to_buy_and_sell_stocks;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int currentMin = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > currentMin) {
                maxProfit = Math.max(prices[i] - currentMin, maxProfit);
            } else {
                currentMin = prices[i];
            }
        }
        return maxProfit;
    }
}
