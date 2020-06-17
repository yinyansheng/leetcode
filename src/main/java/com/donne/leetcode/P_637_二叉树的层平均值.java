package com.donne.leetcode;

import com.donne.leetcode.model.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-11
 */
public class P_637_二叉树的层平均值 {
    public static void main(String[] args) {

    }


    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();

        if (null == root) {
            return ans;
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

            ans.add(avg(list));
        }

        return ans;
    }

    private double avg(List<Integer> list) {
        double sum = 0;
        for (Integer r : list) {
            sum += r;
        }

        return sum / list.size();
    }
}
