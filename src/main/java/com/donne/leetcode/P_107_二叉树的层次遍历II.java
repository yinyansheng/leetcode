package com.donne.leetcode;

import com.donne.leetcode.model.TreeNode;

import java.util.*;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-11
 */
public class P_107_二叉树的层次遍历II {



    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (null == root) {
            return lists;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int currentQueueSize = queue.size();

            for (int i = 0; i < currentQueueSize; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);

                if (null != poll.left) {
                    queue.add(poll.left);
                }

                if (null != poll.right) {
                    queue.add(poll.right);
                }
            }
            lists.add(list);
        }

        //reverse
        Collections.reverse(lists);
        return lists;
    }
}
