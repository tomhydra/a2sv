package com.tomhydra.a2sv.leetcode.greedy._649_dota2_senate;

import java.util.*;

public class Solution {
    public String predictPartyVictory(String senate) {
        char[] senators = senate.toCharArray();
        int rCount = 0;
        int dCount = 0;
        LinkedList<Character> queue = new LinkedList<>();
        for (char c : senators) {
            queue.addLast(c);
            if (c == 'R') rCount++;
            if (c == 'D') dCount++;
        }
        
        int rToRemove = 0;
        while (!queue.isEmpty() && rCount > 0 && dCount > 0) {
            char c = queue.removeFirst();
            if (c == 'D') {
                if (rToRemove >= 0) {
                    queue.addLast(c);
                } else {
                    dCount--;
                }
                rToRemove++;
            } else {
                if (rToRemove <= 0) {
                    queue.addLast(c);    
                } else {
                    rCount--;
                }  
                rToRemove--;
            }
        }
        return dCount == 0 ? "Radiant" : "Dire";
    }
}