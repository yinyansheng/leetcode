package com.donne.leetcode;

import com.donne.leetcode.model.TreeNode;

public class P_230_二叉搜索树中第K小的元素 {
    public int kthSmallest(TreeNode root, int k) {
        midOrder(root, k);
        return ans;
    }

    int ans = -1;
    int num = 0;

    public void midOrder(TreeNode root, int k) {
        if (root.left != null) {
            midOrder(root.left, k);
        }

        num++;
        if (k == num) {
            ans = root.val;
            return;
        }

        if (root.right != null) {
            midOrder(root.right, k);
        }
    }

}
