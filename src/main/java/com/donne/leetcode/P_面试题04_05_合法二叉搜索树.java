package com.donne.leetcode;

import com.donne.leetcode.model.TreeNode;

/**
 * @Author: yinyansheng
 * @Date: 2020-07-01
 */
public class P_面试题04_05_合法二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        if (null == root) {
            return false;
        }

        return isValidBST(root.left, Long.MIN_VALUE, root.val) && isValidBST(root.left, root.val, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }


        if (root.val <= min || root.val >= max) {
            return false;
        }

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }


}
