package com.tomhydra.a2sv.leetcode.sliding_window._978_longest_turbulent_subarray;

class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if (arr == null) return 0;
        if (arr.length < 2) return arr.length;
        int len = arr.length;
        int left = 0, right = 1;
        boolean oddPeak = arr[1] > arr[0];
        int longest = 0;

        while (right < len ) {

            if ((oddPeak && !((right % 2 == 1 && arr[right] > arr[right - 1]) ||
                    (right % 2 == 0 && arr[right] < arr[right - 1]))) ||
                    (!oddPeak && !((right % 2 == 0 && arr[right] > arr[right - 1]) ||
                            (right % 2 == 1 && arr[right] < arr[right - 1])))) {

                longest = Math.max(longest, right - left);
                // skip any duplicate numbers
                while (right < len && arr[right] == arr[right - 1]) {
                    right++;
                }
                left = right - 1;
                oddPeak = !oddPeak;
            } else {
                right++;
            }
        }
        return Math.max(longest, right - left);
    }
}