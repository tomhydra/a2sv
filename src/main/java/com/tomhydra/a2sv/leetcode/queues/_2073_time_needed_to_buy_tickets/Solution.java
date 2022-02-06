package com.tomhydra.a2sv.leetcode.queues._2073_time_needed_to_buy_tickets;

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int maxSeconds = tickets[k];
        int totalSeconds = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i > k && tickets[i] >= maxSeconds) {
                totalSeconds += maxSeconds - 1;
            } else {
                totalSeconds += Math.min(maxSeconds, tickets[i]);
            }
        }
        return totalSeconds;
    }
}