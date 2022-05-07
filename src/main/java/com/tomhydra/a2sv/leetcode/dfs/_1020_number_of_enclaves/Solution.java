package com.tomhydra.a2sv.leetcode.dfs._1020_number_of_enclaves;

import java.util.*;

public class Solution {
    int[][] directions = new int[][] {{-1,0},{0,-1},{1,0},{0,1}};
    public int numEnclaves(int[][] grid) {
        int nRow = grid.length;
        int nCol = grid[0].length;
        
        for (int row = 0; row < nRow; row++) {
            convertToSeaCell(grid, row, 0);
            convertToSeaCell(grid, row, nCol - 1);
        }
        
        for (int col = 0; col < nCol; col++) {
            convertToSeaCell(grid, 0, col);
            convertToSeaCell(grid, nRow - 1, col);
        }
        int landCells = 0;
        for (int row = 0; row < nRow; row++) {
            for (int col = 0; col < nCol; col++) {
                if (grid[row][col] == 1) {
                    landCells++;
                }
            }
        }
        return landCells;
    }
    
    private void convertToSeaCell(int[][] grid, int row, int col) {
        if (grid[row][col] != 1) return;
        grid[row][col] = 0;
        
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            
            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length 
                && grid[newRow][newCol] == 1) {
                convertToSeaCell(grid, newRow, newCol);
            }
        }
        
    }
}