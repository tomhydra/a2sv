package com.tomhydra.a2sv.leetcode.dsu._990_satisfiability_of_equality_equations;

import java.util.*;

public class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] letters = new int[26];
        DisjointSet ds = new DisjointSet(letters.length);
        for (String equation: equations) {
            if (equation.charAt(1) == '=') {
                ds.union(equation.charAt(0), equation.charAt(3));
            }
        }
        
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int first = equation.charAt(0) - 'a';
                int second = equation.charAt(3) - 'a';
                int firstParent = ds.find(first);
                int secondParent = ds.find(second);
                
                if (firstParent == secondParent) return false;
            }
        }
        return true;
    }
}

class DisjointSet {
    private int[] parents;
    private int[] ranks;
    
    public DisjointSet(int n) {
        parents = new int[n];
        ranks = new int[n];
        
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
    }
    
    public void union(char x, char y) {
        int parentX = find(x - 'a');
        int parentY = find(y - 'a');
        
        if (parentX != parentY) {
            if (ranks[parentX] >= ranks[parentY]) {
                parents[parentY] = parentX;
                ranks[parentX]++;
            } else {
                parents[parentX] = parentY;
                ranks[parentY]++;
            }
        }
    }
    
    public int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
}