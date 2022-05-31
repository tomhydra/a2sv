package com.tomhydra.a2sv.leetcode.dsu._684_redundant_connection;

import java.util.*;

public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                return edge;
            }
        }
        throw new IllegalArgumentException("The graph is already a tree!");
    }
    
}

class UnionFind {
    
    private int[] parents;
    private int[] ranks;
    
    public UnionFind(int n) {
        this.parents = new int[n+1];
        this.ranks = new int[n+1];
        
        for (int i = 1; i <= n; i++) {
            this.parents[i] = i;
        }
    }
    
    public boolean union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        
        if (parentX != parentY) {
            if (ranks[parentX] >= ranks[parentY]) {
                parents[parentY] = parentX;
                ranks[parentX]++;
            } else {
                parents[parentX] = parentY;
                ranks[parentY]++;
            }
            return true;
        }
        return false;
    }
    
    public int find(int x) {
        if (x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }
}