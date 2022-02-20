package com.tomhydra.a2sv.leetcode.sliding_window._904_fruit_into_baskets;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int totalFruit(int[] fruits) {
        Set<Integer> fruitTypes = new HashSet<>();
        int totalCollected = 0;
        int left = 0;

        for (int i = 0; i < fruits.length; i++) {
            if (fruitTypes.size() < 2) {
                fruitTypes.add(fruits[i]);
            } else {
                if (!fruitTypes.contains(fruits[i])) {
                    // calculate number of collected fruits
                    totalCollected = Math.max(totalCollected, i - left);

                    // reset left pointer and remove invalid fruit
                    left = i - 1;
                    while (left >= 0 && fruits[left] == fruits[i-1]) {
                        left--;
                    }
                    if (left >= 0) {
                        fruitTypes.remove(fruits[left]);
                        left++;
                    }

                    // add the new fruit
                    fruitTypes.add(fruits[i]);
                }
            }
        }
        return Math.max(fruits.length - left, totalCollected);
    }
}