package com.tomhydra.a2sv.leetcode.hashing._205_isomorphic_strings;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        // validate input
        if (s == null || t == null || s.length() != t.length()) return false;

        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        int n = s.length();

        for (int i = 0; i < n; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (sMap.containsKey(sChar) && sMap.get(sChar) != tChar) return false;
            if (tMap.containsKey(tChar) && tMap.get(tChar) != sChar) return false;
            sMap.put(sChar, tChar);
            tMap.put(tChar, sChar);
        }

        return true;
    }
}