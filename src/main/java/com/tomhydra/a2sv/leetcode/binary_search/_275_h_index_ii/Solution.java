package com.tomhydra.a2sv.leetcode.binary_search._275_h_index_ii;

class Solution {
    public int hIndex(int[] citations) {
        int left = 0, right = citations.length - 1, mid = 0;
        int max = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            int papersToTheRight = citations.length - mid;
            if (citations[mid] >= papersToTheRight) {
                max = Math.max(max, papersToTheRight);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return max;
    }
}