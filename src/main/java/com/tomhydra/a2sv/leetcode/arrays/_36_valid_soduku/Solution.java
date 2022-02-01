package com.tomhydra.a2sv.leetcode.arrays._36_valid_soduku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        List<Set<Character>> horizontal = new ArrayList<>();
        List<Set<Character>> vertical = new ArrayList<>();
        List<Set<Character>> box = new ArrayList<>();

        for (int row = 0; row < board.length; row++) {
            horizontal.add(new HashSet<>());
            vertical.add(new HashSet<>());
            box.add(new HashSet<>());
        }


        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == '.') continue;
                if (!horizontal.get(row).add(board[row][col])) return false;
                if (!vertical.get(col).add(board[row][col])) return false;

                int boxIndex = (row / 3) * 3 + col / 3;
                if (!box.get(boxIndex).add(board[row][col])) return false;

            }
        }

        return true;
    }
}