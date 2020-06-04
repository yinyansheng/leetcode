package com.donne.leetcode;

import com.donne.leetcode.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class P_513_找树左下角的值 {
    public static void main(String[] args) {

    }

    public static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int ans = -1;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            ans=poll.val;

            if (poll.right != null) {
                queue.add(poll.right);
            }

            if (poll.left != null) {
                queue.add(poll.left);
            }
        }

        return ans;
    }
}
