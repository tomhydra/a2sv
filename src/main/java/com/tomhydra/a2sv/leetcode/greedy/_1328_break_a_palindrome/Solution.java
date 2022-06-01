package com.tomhydra.a2sv.leetcode.greedy._1328_break_a_palindrome;

import java.util.*;

public class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) return "";
        
        int half = (palindrome.length() + 1) / 2;
        for (int i = 0; i < half; i++) {
            if (palindrome.charAt(i) != 'a') {
                if (i == half - 1 && palindrome.length() % 2 == 1) {
                    break;
                } 
                return palindrome.substring(0, i) + "a" + palindrome.substring(i+1, palindrome.length());  
            }
        }
        return palindrome.substring(0,palindrome.length() - 1) + "b";
    }
}