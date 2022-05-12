package com.tomhydra.a2sv.leetcode.dp._120_triangle;

import java.util.*;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) return triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int min = Integer.MAX_VALUE;
                List<Integer> prev = triangle.get(i-1);
                if (j - 1 >= 0) {
                    min = Math.min(min, prev.get(j-1));
                }
                if (j < prev.size()) {
                    min = Math.min(min, prev.get(j));
                }
                triangle.get(i).set(j, min + triangle.get(i).get(j));
            }
        }
        
        List<Integer> last = triangle.get(triangle.size() - 1);
        int min = last.get(0);
        for (int i = 1; i < last.size(); i++) {
            min = Math.min(min, last.get(i));
        }
        return min;
    }
}