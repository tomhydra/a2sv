package com.tomhydra.a2sv.leetcode.topological._802_find_eventual_safe_states;

import java.util.*;

public class Solution {
    boolean[] visited;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Set<Integer> result = new HashSet<>();
        visited = new boolean[graph.length];
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            if (!cache.containsKey(i)) {
                dfs(graph, i, cache, result);
            }
        }
        List<Integer> resultList = new ArrayList<>(result);
        Collections.sort(resultList);
        return resultList;
    }
    
    private boolean dfs(int[][] graph, int node, Map<Integer, Integer> cache, Set<Integer> result) {
        if (cache.containsKey(node)) {
            if (cache.get(node) == 2 || cache.get(node) == 1) {
                return false;
            } 
            return true;
        }
        cache.put(node, 2); // being visited
        
        boolean isSafe = true;
        for (int child : graph[node]) {
            isSafe &= dfs(graph, child, cache, result);
        }
        cache.put(node, isSafe ? 0 : 1);
        if (isSafe) {
            result.add(node);
        }
        return isSafe;
    }   
    
}