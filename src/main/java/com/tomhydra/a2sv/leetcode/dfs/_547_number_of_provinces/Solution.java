package com.tomhydra.a2sv.leetcode.dfs._547_number_of_provinces;

import java.util.*;

public class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        for (int row = 0; row < isConnected.length; row++) {
            for (int col = 0; col < isConnected[0].length; col++) {
                if (isConnected[row][col] == 1) {
                    provinces++;
                    dfs(isConnected, row);
                }
            }
        }
        return provinces;
    }
    
    private void dfs(int[][] isConnected, int city) {
        for (int row = 0; row < isConnected.length; row++) {
            if (isConnected[row][city] == 1) {
                isConnected[row][city] *= -1;
                dfs(isConnected, row);
            }
        }
    }
}