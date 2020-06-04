package com.donne.leetcode;

import com.donne.leetcode.model.TreeNode;

public class P_100_相同的树 {

    public static void main(String[] args) {

        TreeNode p = new TreeNode(1);
        p.right = new TreeNode(2);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);

        System.out.println(isSameTree(p, q));

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        //根节点检查
        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
