package com.donne.leetcode;

import com.donne.leetcode.model.TreeNode;

public class P_104_二叉树的最大深度 {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left) + 1;
        int rightDepth = maxDepth(root.right) + 1;
        return Math.max(leftDepth, rightDepth);

    }
}
