package com.tomhydra.a2sv.leetcode.dfs._695_max_area_of_island;

import java.util.*;

public class Solution {
    int[][] directions = new int[][] {{-1,0},{0,-1},{1,0},{0,1}};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    maxArea = Math.max(maxArea, calculateArea(grid, row, col));
                }
            }
        }
        return maxArea;
    }
    
    private int calculateArea(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return 0;
        if (grid[row][col] != 1) return 0;
        grid[row][col] = 0; // visit
        int area = 1;
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            area += calculateArea(grid, newRow, newCol);
        }
        return area;
    }
}