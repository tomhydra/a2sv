package com.tomhydra.a2sv.leetcode.greedy._605_can_place_flowers;

import java.util.*;

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        if (flowerbed.length == 1 && flowerbed[0] == 0 && n == 1) return true;
        if (flowerbed.length > 1) {
            if (flowerbed[0] == 0 && flowerbed[1] == 0) {
                flowerbed[0] = 1;
                n--;
            }
        }
        for (int i = 1; i < flowerbed.length - 1; i++) {
            if (flowerbed[i] == 0) {
                if (flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                } else if (i == flowerbed.length - 2 && flowerbed[i+1] == 0) {
                    flowerbed[i+1] = 1;
                    n--;
                }
            }
            if (n == 0) break;
        }
        return n <= 0;
    }
}