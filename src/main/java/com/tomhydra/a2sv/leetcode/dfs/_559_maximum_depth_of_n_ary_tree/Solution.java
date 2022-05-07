package com.tomhydra.a2sv.leetcode.dfs._559_maximum_depth_of_n_ary_tree;

import com.tomhydra.a2sv.leetcode.common.Node;

public class Solution {
    int maxDepth = 0;
    public int maxDepth(Node root) {
        updateMaxDepth(root, 0);
        return maxDepth;
    }
    
    private void updateMaxDepth(Node node, int level) {
        if (node == null) return;
        level++;
        if (node.children.size() == 0) {
            maxDepth = Math.max(maxDepth, level);
        } else {
            for (Node child : node.children) {
                updateMaxDepth(child, level);                
            }
        }
    }
}