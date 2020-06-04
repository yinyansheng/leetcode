package com.donne.leetcode;

import com.donne.leetcode.model.TreeNode;

public class P_面试题55_I_二叉树的深度 {
    public static void main(String[] args) {

    }


    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
