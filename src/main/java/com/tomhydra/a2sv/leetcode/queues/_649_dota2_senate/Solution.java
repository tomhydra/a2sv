package com.tomhydra.a2sv.leetcode.queues._649_dota2_senate;

import java.util.LinkedList;

class Solution {
    public String predictPartyVictory(String senate) {
        LinkedList<Character> queue = new LinkedList<>();
        int radiants = 0, dires = 0;
        for (char c : senate.toCharArray()) {
            if (c == 'R') radiants ++;
            else dires++;
            queue.addLast(c);
        }

        // either senators can be used here
        // removeDires > 0 means we remove dires and
        // removeDires < 0 means we remove radiants
        int removeDires = 0;
        while (!queue.isEmpty() && dires > 0 && radiants > 0) {
            char c = queue.removeFirst();
            if (c == 'R') {
                if (removeDires >= 0) {
                    queue.addLast(c);
                } else {
                    radiants--;
                }
                removeDires++;
            } else {
                if (removeDires <= 0) {
                    queue.addLast(c);
                } else {
                    dires--;
                }
                removeDires--;
            }

        }
        return dires == 0 ? "Radiant" : "Dire";
    }
}