package com.tomhydra.a2sv.leetcode.binary_search._278_first_bad_version;

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n, mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                if (isBadVersion(mid + 1)) {
                    return mid + 1;
                }
                left = mid + 1;
            }
        }
        return left;
    }
}

class VersionControl {
    boolean isBadVersion(int val) {
        // NOTE: This is just a placeholder for the leetcode VersionControl class
        return true;
    }
}