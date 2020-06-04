package com.donne.leetcode;

import com.donne.leetcode.model.TreeNode;

public class P_110_平衡二叉树 {
    public static void main(String[] args) {

    }

    public static boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }

        if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) {
            return false;
        }

        return isBalanced(root.right) && isBalanced(root.left);
    }

    public static int getDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
