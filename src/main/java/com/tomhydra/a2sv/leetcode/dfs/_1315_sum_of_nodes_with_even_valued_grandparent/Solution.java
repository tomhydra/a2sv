package com.tomhydra.a2sv.leetcode.dfs._1315_sum_of_nodes_with_even_valued_grandparent;

import com.tomhydra.a2sv.leetcode.common.TreeNode;

public class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        return sumEvenGrandparent(root, 0, false);
    }
    
    private int sumEvenGrandparent(TreeNode node, int evenParents, boolean parentIsEven) {
        if (node == null) return 0;
        int currentSum = 0;
        if (evenParents == 2 || (evenParents == 1 && !parentIsEven)) {
            currentSum += node.val;
            evenParents--;
        }
        
        boolean isEven = node.val % 2 == 0;
        
        if (isEven) {
            evenParents++;
        }
        
        int leftSum = sumEvenGrandparent(node.left, evenParents, isEven);
        int rightSum = sumEvenGrandparent(node.right, evenParents, isEven);
        
        return currentSum + leftSum + rightSum;
    }
}