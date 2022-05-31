package com.tomhydra.a2sv.leetcode.dsu._1202_smallest_string_with_swaps;

import java.util.*;

public class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        DisjointSet dset = new DisjointSet(s.length());
        for (List<Integer> pair: pairs) {
            dset.union(pair.get(0), pair.get(1));
        }
        
        
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            int parent = dset.find(i);
            map.computeIfAbsent(parent, k -> new PriorityQueue<Character>())
                .add(s.charAt(i));
        }
        
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int parent = dset.find(i);
            result.append(map.get(parent).poll());
        }
        return result.toString();
    }
}

class DisjointSet {
    
    private int[] parents;
    private int[] ranks;
    
    
    public DisjointSet(int n) {
        this.parents = new int[n];
        this.ranks = new int[n];
        
        for (int i = 0; i < parents.length; i++) {
            this.parents[i] = i;
        }
    }
    
    public void union(int first, int second) {
        int firstParent = find(first);
        int secondParent = find(second);
        
        if (firstParent != secondParent) {
            if (ranks[firstParent] >= ranks[secondParent]) {
                parents[secondParent] = firstParent;
                ranks[firstParent]++;
            } else {
                parents[firstParent] = secondParent;
                ranks[secondParent]++;
            }
        }
    }
    
    public int find(int val) {
        if (parents[val] == val) return val;
        return parents[val] = find(parents[val]);
    }
    
}