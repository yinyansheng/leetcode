package com.donne.leetcode;

import com.donne.leetcode.model.TreeNode;

public class P_101_对称二叉树 {

    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isMirror(root.left,root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return right.val == left.val
                && isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }
}
