package com.tomhydra.a2sv.leetcode.hashing._73_set_matrix_zeroes;

class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int nRow = matrix.length;
        int nCol = matrix[0].length;
        boolean[] rows = new boolean[nRow];
        boolean[] cols = new boolean[nCol];

        for (int row = 0; row < nRow; row++) {
            for (int col = 0; col < nCol; col++) {
                if (matrix[row][col] == 0) {
                    rows[row] = true;
                    cols[col] = true;
                }
            }
        }

        for (int row = 0; row < nRow; row++) {
            for (int col = 0; col < nCol; col++) {
                if (rows[row] || cols[col]) {
                    matrix[row][col] = 0;
                }
            }
        }
    }
}