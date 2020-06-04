package com.donne.leetcode;

import com.donne.leetcode.model.TreeNode;

public interface P_面试题55_II_平衡二叉树 {
    public static void main(String[] args) {

    }

    public static boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }

        if (Math.abs(getDepth(root.right) - getDepth(root.left)) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }
}
