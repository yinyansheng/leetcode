package com.donne.leetcode;

import com.donne.leetcode.model.TreeNode;

public class P_112_路径总和 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        sum -= root.val;
        if(root.left==null  && root.right==null){
            return 0==sum;
        }

        return hasPathSum(root.right,sum ) || hasPathSum(root.left, sum);
    }
}
