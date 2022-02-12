package com.tomhydra.a2sv.leetcode.sorting._1985_find_the_kth_largest_integer_in_the_array;

import java.util.PriorityQueue;

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> a.compareTo(b));

        int longest = 0;
        for (String num : nums) {
            longest = Math.max(num.length(), longest);
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = padWithZeros(nums[i], longest);
        }

        for (String num : nums) {
            minHeap.add(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return removeLeadingZeros(minHeap.peek());

    }

    private String padWithZeros(String num, int size) {
        int numSize = num.length();
        if (numSize == size) return num;
        return "0".repeat(size - numSize) + num;
    }

    private String removeLeadingZeros(String num) {
        if (num.length() == 1) return num;
        int start = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '0') {
                start++;
            } else {
                break;
            }
        }
        // leave the last 0
        if (start == num.length()) {
            start = num.length() - 1;
        }
        return num.substring(start, num.length());
    }
}