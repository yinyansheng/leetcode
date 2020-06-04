package com.donne.leetcode;

import com.donne.leetcode.model.TreeNode;

public class P_98_验证二叉搜索树 {
    public static void main(String[] args) {

    }

    /**
     * 递归
     *
     * @param root
     * @param lower
     * @param upper
     * @return
     */
    public static boolean isValidBST(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }

        if (upper != null && root.val >= upper) {
            return false;
        }

        if (lower != null && root.val <= lower) {
            return false;
        }

        return isValidBST(root.right, root.val, upper) && isValidBST(root.left, lower, root.val);
    }

}
