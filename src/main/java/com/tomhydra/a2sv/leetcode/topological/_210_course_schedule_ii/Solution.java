package com.tomhydra.a2sv.leetcode.topological._210_course_schedule_ii;

import java.util.*;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> indegrees = new HashMap<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            indegrees.put(i, 0);
            graph.put(i, new HashSet<>());
        }
        
        for (int[] pre : prerequisites) {
            indegrees.put(pre[0], indegrees.get(pre[0]) + 1);
            graph.get(pre[1]).add(pre[0]);
        }
        
        for (Map.Entry<Integer, Integer> entry : indegrees.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        } 
        
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);
            for (int child : graph.get(current)) {
                indegrees.put(child, indegrees.get(child) - 1);
                if (indegrees.get(child) == 0) {
                    queue.offer(child);
                }
            }
        }
        
        return result.size() == numCourses ? result.stream().mapToInt(i -> i).toArray() : new int[0];
    }
}