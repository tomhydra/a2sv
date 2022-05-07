package com.tomhydra.a2sv.leetcode.bfs._1306_jump_game_iii;

import java.util.*;

public class Solution {
    public boolean canReach(int[] arr, int start) {
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (arr[current] == 0) return true;
                visited.add(current);
                int left = current - arr[current];
                int right = current + arr[current];
                if (left >= 0 && !visited.contains(left)) {
                    queue.add(left);
                }
                if (right < arr.length && !visited.contains(right)) {
                    queue.add(right);
                }
            }
        }
        return false;
    }
}