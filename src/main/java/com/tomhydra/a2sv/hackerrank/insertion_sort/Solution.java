package com.tomhydra.a2sv.hackerrank.insertion_sort;

import java.util.List;

public class Solution {
    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        int toAdd = arr.get(n - 1);
        int i = n - 1;
        while (i > 0 && toAdd < arr.get(i-1)) {
            arr.set(i, arr.get(i-1));
            printArray(arr);
            i--;
        }
        arr.set(i, toAdd);
        printArray(arr);

    }

    private static void printArray(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.printf("%d", arr.get(i));
            if (i != arr.size() - 1) {
                System.out.printf(" ");
            } else {
                System.out.println();
            }
        }
    }
}
