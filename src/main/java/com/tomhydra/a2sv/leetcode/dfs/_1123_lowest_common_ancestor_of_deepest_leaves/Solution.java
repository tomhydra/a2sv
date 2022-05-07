package com.tomhydra.a2sv.leetcode.dfs._1123_lowest_common_ancestor_of_deepest_leaves;

import com.tomhydra.a2sv.leetcode.common.TreeNode;

public class Solution {
    TreeNode lca = null;
    int maxLevel = 0;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        lca = root;
        dfs(root, 1);
        return lca;
    }
    
    private int dfs(TreeNode node, int level) {
        if (node == null) return level;
        
        int right = dfs(node.right, level + 1);
        int left = dfs(node.left, level + 1);
        
        
        if (left == right && right >= maxLevel) {
            lca = node;
            maxLevel = right;
        }
        
        return Math.max(left, right);
    }
}
