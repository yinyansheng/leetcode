package com.donne.leetcode;

import com.donne.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P_113_路径总和II {

    public void pathSum(List<List<Integer>> result, List<Integer> curr, TreeNode root, int sum, int target) {
        if (root == null) {
            return;
        }

        curr.add(root.val);
        sum += root.val;
        if (root.left == null && root.right == null && sum == target) {
            result.add(curr);
        }

        if (sum > target) {
            return;
        }

        pathSum(result, new ArrayList<>(curr), root.left, sum, target);
        pathSum(result, new ArrayList<>(curr), root.right, sum, target);
    }

}
