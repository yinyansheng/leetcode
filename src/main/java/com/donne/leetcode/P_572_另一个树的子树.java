package com.donne.leetcode;

import com.donne.leetcode.model.TreeNode;

public class P_572_另一个树的子树 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return isSameTree(s, t)||isSubtree(s.right, t) || isSubtree(s.left, t);
    }

    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (null == s && null == t) {
            return true;
        }

        if (null == s || null == t) {
            return false;
        }

        if (s.val != t.val) {
            return false;
        }

        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
