package com.tomhydra.a2sv.leetcode.dfs._563_binary_tree_tilt;

import com.tomhydra.a2sv.leetcode.common.TreeNode;

public class Solution {
    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        return findTiltHelper(root).tilt;
    }
    public TiltSumPair findTiltHelper(TreeNode root) {
        if (root == null) return new TiltSumPair(0,0);
        TiltSumPair left = findTiltHelper(root.left);
        TiltSumPair right = findTiltHelper(root.right);
        int sum = root.val + left.sum + right.sum;
        int tilt = Math.abs(right.sum - left.sum) + left.tilt + right.tilt;
        return new TiltSumPair(tilt,sum);
    }
}

class TiltSumPair {
    public int tilt;
    public int sum;
    
    public TiltSumPair(int tilt, int sum) {
        this.tilt = tilt;
        this.sum = sum;
    }
    
    @Override
    public String toString() {
        return "{ " + tilt + " , " + sum + " }";
    }
}