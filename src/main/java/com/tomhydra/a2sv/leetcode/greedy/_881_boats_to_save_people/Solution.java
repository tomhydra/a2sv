package com.tomhydra.a2sv.leetcode.greedy._881_boats_to_save_people;

import java.util.*;

public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1, together = 0;
        int boats = 0;
        while (left <= right) {
            together = people[left] + people[right];
            if (together <= limit) {
                left++;
            } 
            right--;
            boats++;
        }
        return boats;
    }
}