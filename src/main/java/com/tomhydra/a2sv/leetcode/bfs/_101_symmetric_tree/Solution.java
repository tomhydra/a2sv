package com.tomhydra.a2sv.leetcode.bfs._101_symmetric_tree;

import com.tomhydra.a2sv.leetcode.common.TreeNode;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        if (root == null) return true;
        return areEqual(root.left, root.right);
    }
    
    private boolean areEqual(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && areEqual(left.left, right.right) && areEqual(left.right, right.left);
    }
}
