package com.donne.leetcode;

import com.donne.leetcode.model.TreeNode;

/**
 * @Author: yinyansheng
 * @Date: 2020-07-15
 */
public class P_124_二叉树中的最大路径和 {

    private Integer ans = Integer.MIN_VALUE;

    public int dfs(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        ans = Math.max(left + right + root.val, ans);
        return Math.max(left + root.val, right + root.val);
    }
}
