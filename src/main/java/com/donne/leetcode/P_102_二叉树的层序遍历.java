package com.donne.leetcode;

import com.donne.leetcode.model.TreeNode;

import java.util.*;

public class P_102_二叉树的层序遍历 {
    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);

        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);

        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;
        root3.left = root6;


        /**
         *          1
         *      2       3
         *  4       5
         */

        levelOrder(root1);
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (null == root) {
            return Collections.emptyList();
        }

        List<List<Integer>> lists = new ArrayList<>();

        Queue<TreeNode> first = new ArrayDeque<>();
        Queue<TreeNode> second = new ArrayDeque<>();

        first.add(root);

        List<Integer> list = new ArrayList<>();
        while (!first.isEmpty()) {
            TreeNode poll = first.poll();
            list.add(poll.val);

            if (poll.left != null) {
                second.add(poll.left);
            }

            if (poll.right != null) {
                second.add(poll.right);
            }

            if (first.isEmpty()) {
                lists.add(list);
                first = second;
                list = new ArrayList<>();
                second = new ArrayDeque<>();
            }
        }

        return lists;
    }
}
