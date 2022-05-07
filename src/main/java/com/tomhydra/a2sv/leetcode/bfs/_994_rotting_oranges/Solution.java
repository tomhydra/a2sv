package com.tomhydra.a2sv.leetcode.bfs._994_rotting_oranges;

import java.util.*;

public class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions = new int[][] {{-1,0},{0,1},{1,0}, {0,-1}};
        
        LinkedList<int[]> queue = new LinkedList<>();
        int allFreshTomatoes = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    queue.add(new int[]{row,col, 0});
                } else if (grid[row][col] == 1) {
                    allFreshTomatoes++;
                }
            }
        }
        
        int maxMinutes = 0;
        while (!queue.isEmpty()) {
            int[] idx = queue.poll();
            
            for (int[] direction : directions) {
                int[] next = new int[] {idx[0] + direction[0], idx[1] + direction[1], idx[2] + 1};
                
                if (next[0] < grid.length && next[1] < grid[0].length && 
                    next[0] >= 0 && next[1] >= 0 && grid[next[0]][next[1]] == 1) {
                    grid[next[0]][next[1]] = 2;
                    allFreshTomatoes--;
                    queue.add(next);
                    maxMinutes = Math.max(next[2], maxMinutes);
                }
                
            }
            
        }
        return allFreshTomatoes == 0 ? maxMinutes : -1;
    }
    
        
}