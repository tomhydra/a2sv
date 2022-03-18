package com.tomhydra.a2sv.leetcode.binary_search._1237_find_positive_integer_solution_for_a_given_solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<>();
        int n = 100;
        int left = 1, right = n;
        while (left < n || right > 1) {
            int out = customfunction.f(left, right);
            if (out == z) {
                result.add(Arrays.asList(left, right));
                left = left < n ? left + 1 : left;
                right = right > 1 ? right - 1 : right;
            } else if (out > z) {
                if (right == 1) {
                    left++;
                } else {
                    right--;
                }
            } else {
                if (left == n) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        if (customfunction.f(n, 1) == z) result.add(Arrays.asList(n, 1));
        return result;
    }
}

// placeholder for CustomFunction
class CustomFunction {
    public int f(int n, int i) {
        return 0;
    }
}