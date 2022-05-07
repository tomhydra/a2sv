package com.tomhydra.a2sv.leetcode.bfs._103_binary_tree_zigzag_level_order_traversal;

import com.tomhydra.a2sv.leetcode.common.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelResult = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                levelResult.add(current.val);
                
                if (current.left != null) {
                    queue.add(current.left);
                }
                
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            if (level % 2 == 1) {
                Collections.reverse(levelResult);
            }
            result.add(levelResult);
            level++;
                
        }
        return result;
    }
}