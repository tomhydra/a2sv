package com.tomhydra.a2sv.leetcode.dfs._130_surrounded_regions;

import java.util.*;

public class Solution {
    int[][] directions = new int[][] {{-1,0},{0,-1},{1,0}, {0,1}};
    public void solve(char[][] board) {
        int nCol = board[0].length;
        int nRow = board.length;
        
        replaceCornerOs(board, nRow, nCol);
        
        // capture 'O's
        for (int row = 0; row < nRow; row++) {
            for (int col = 0; col < nCol; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
            }
        }

        // reset corder 'O's
        for (int row = 0; row < nRow; row++) {
            for (int col = 0; col < nCol; col++) {
                if (board[row][col] == 'R') {
                    board[row][col] = 'O';
                }
            }
        }
        
    }
    
    private void replaceCornerOs(char[][] board, int nRow, int nCol) {
        for (int row = 0; row < nRow; row++) {
            if (board[row][0] == 'O') {
                dfs(board, row, 0, 'O', 'R');
            }
            if (board[row][nCol - 1] == 'O') {
                dfs(board, row, nCol - 1, 'O', 'R');
            }
        }
        
        for (int col = 0; col < nCol; col++) {
            if (board[0][col] == 'O') {
                dfs(board, 0, col, 'O', 'R');
            }
            if (board[nRow - 1][col] == 'O') {
                dfs(board, nRow - 1, col, 'O', 'R');
            }
        }
    }
    
    private void dfs(char[][] board, int row, int col, char from, char to) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) return;
        if (board[row][col] != from) return;
        board[row][col] = to;
        
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            dfs(board, newRow, newCol, from, to);
        }
        
    }
}