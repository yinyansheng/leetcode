package com.donne.temp;

import com.donne.leetcode.model.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-11
 */
public class T4 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();

        //corner case
        if (null == root) {
            return lists;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int currentQueueSize = queue.size();
            List<Integer> list = new ArrayList<>();
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

        return lists;
    }
}
