package com.donne.leetcode;

import com.donne.leetcode.model.TreeNode;

public class P_687_最长同值路径 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1);
        TreeNode root3 = new TreeNode(1);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;
        root3.left = root6;

        System.out.println(longestUnivaluePath(root1));


    }

    static int res = 0;

    public static int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = longestUnivaluePath(root.left);
        int right = longestUnivaluePath(root.right);

        int leftCount = 0;
        if (root.left != null && root.val == root.left.val) {
            leftCount = left + 1;
        }

        int rightCount = 0;
        if (root.right != null && root.val == root.right.val) {
            rightCount = right + 1;
        }

        res = Math.max(res, leftCount + right);
        return Math.max(leftCount, rightCount);
    }
}
