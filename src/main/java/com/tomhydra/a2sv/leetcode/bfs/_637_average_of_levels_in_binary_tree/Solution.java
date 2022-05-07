package com.tomhydra.a2sv.leetcode.bfs._637_average_of_levels_in_binary_tree;

import com.tomhydra.a2sv.leetcode.common.TreeNode;

import java.util.*;

public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root ==  null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                sum += current.val;
                
                if (current.left != null) {
                    queue.add(current.left);
                }
                
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            result.add(sum / size);
        }
        
        return result;
    }
}