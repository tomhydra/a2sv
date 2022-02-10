package com.tomhydra.a2sv.hackerrank.counting_sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        List<Integer> count = new ArrayList<>(Collections.nCopies(100, 0));

        for (int num : arr) {
            count.set(num, count.get(num) + 1);
        }

        return count;

    }
}
