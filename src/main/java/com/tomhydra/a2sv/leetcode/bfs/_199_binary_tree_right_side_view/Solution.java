package com.tomhydra.a2sv.leetcode.bfs._199_binary_tree_right_side_view;

import com.tomhydra.a2sv.leetcode.common.TreeNode;

import java.util.*;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                
                if (i == size - 1) {
                    result.add(current.val);
                }
            }
        }
        return result;
    }
}