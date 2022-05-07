package com.tomhydra.a2sv.leetcode.dfs._112_path_sum;

import com.tomhydra.a2sv.leetcode.common.TreeNode;

public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, 0, targetSum);
    }
    
    public boolean hasPathSum(TreeNode node, int currentSum, int targetSum) {
        if (node == null) return false;
        currentSum += node.val;
        if (currentSum == targetSum && node.left == null && node.right == null) return true;
        return hasPathSum(node.left, currentSum, targetSum) || hasPathSum(node.right, currentSum, targetSum);
    }
}