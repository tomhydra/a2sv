package com.tomhydra.a2sv.leetcode.binary_search._1351_count_negative_numbers_in_a_sorted_matrix;

class Solution {
    public int countNegatives(int[][] grid) {
        int nRow = grid.length;
        int nCol = grid[0].length;
        int count = 0;

        int right = nCol - 1;
        for (int row = 0; row < nRow; row++) {
            int negativeIndex = getNegativeIndex(grid, row, 0, right);

            if (negativeIndex == -1) continue;
            int toRight = right - negativeIndex + 1;
            int toBottom = nRow - row;

            count += toRight * toBottom;
            right = negativeIndex - 1;
        }

        return count;

    }

    private int getNegativeIndex(int[][] grid, int row, int left, int right) {
        if (grid[row][0] < 0) return 0;
        int mid = 0;
        int len = right;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (grid[row][mid] >= 0) {
                // next item is negative
                if (mid < len && grid[row][mid+1] < 0) return mid + 1;
                left = mid + 1;
            } else if (grid[row][mid] < 0) {
                right = mid - 1;
            }
        }
        return -1; // no negative
    }
}