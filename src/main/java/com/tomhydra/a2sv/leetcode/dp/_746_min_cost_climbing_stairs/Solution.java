package com.tomhydra.a2sv.leetcode.dp._746_min_cost_climbing_stairs;

import java.util.*;

public class Solution {
    private Map<Integer, Integer> dp = new HashMap<>();
    
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (cost == null || n == 0) return 0;
        if (n == 1) return cost[0];
        if (n == 2) return Math.min(cost[0], cost[1]);
        for (int i = 2; i < n; i++) {
            cost[i] = Math.min(cost[i-1], cost[i-2]) + cost[i];
        }
        return Math.min(cost[n - 1], cost[n-2]);
        
    }
    
}