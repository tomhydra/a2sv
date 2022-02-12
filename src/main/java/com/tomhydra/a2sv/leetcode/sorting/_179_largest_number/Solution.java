package com.tomhydra.a2sv.leetcode.sorting._179_largest_number;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String largestNumber(int[] nums) {

        String[] stringNums = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            stringNums[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(stringNums, new LargestNumberComparator());

        if (stringNums[0].equals("0")) return "0";

        StringBuilder result = new StringBuilder();
        for (String num : stringNums) {
            result.append(num);
        }
        return result.toString();
    }
}

class LargestNumberComparator implements Comparator<String> {

    public int compare(String first, String second) {
        String option1 = first + second;
        String option2 = second + first;
        return option2.compareTo(option1);
    }
}