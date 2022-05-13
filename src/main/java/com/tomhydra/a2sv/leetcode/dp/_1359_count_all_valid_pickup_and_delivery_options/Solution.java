package com.tomhydra.a2sv.leetcode.dp._1359_count_all_valid_pickup_and_delivery_options;

import java.util.*;

public class Solution {
    long mod = 1000000007;
    public int countOrders(int n) {
        return (int)countOrdersBig(n);
        
    }
    
    private long countOrdersBig(int n) {
        if (n == 1) return 1;
        long y = (n - 1) * 2 + 1;
        long currentPossible = (y * (y+1) / 2);
        
        return (countOrders(n-1) * currentPossible) % mod;
    }
}
