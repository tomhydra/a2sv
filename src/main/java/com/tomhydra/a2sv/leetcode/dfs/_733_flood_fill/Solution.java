package com.tomhydra.a2sv.leetcode.dfs._733_flood_fill;

import java.util.*;

public class Solution {
    int[][] directions = new int[][] {{-1,0}, {0,1}, {0,-1},{1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void dfs(int[][] image, int row, int col, int oldColor, int newColor) {
        // check boundary
        if (row < 0 || col < 0 || row >= image.length || col >= image[0].length) return;
        // check same color
        if (image[row][col] != oldColor) return;
        
        image[row][col] = newColor;
        
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            dfs(image, newRow, newCol, oldColor, newColor);
        }
        
        
    }
}