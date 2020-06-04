package com.donne.leetcode;

import com.donne.leetcode.model.TreeNode;

import java.util.*;

public class P_199_二叉树的右视图 {

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

        //List<Integer> list = rightSideView(root1);
        List<Integer> list = new ArrayList<>();
        //dfs(root1, list);
        list.forEach(System.out::println);
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (null == root) {
            return list;
        }

        Queue<TreeNode> curr = new ArrayDeque<>();
        Queue<TreeNode> next = new ArrayDeque<>();
        curr.offer(root);

        while (!curr.isEmpty() || !next.isEmpty()) {
            TreeNode poll = curr.poll();

            if (poll.left != null) {
                next.offer(poll.left);
            }

            if (poll.right != null) {
                next.offer(poll.right);
            }

            if (curr.isEmpty()) {
                list.add(poll.val);
                Queue<TreeNode> temp = curr;
                curr = next;
                next = temp;
            }
        }

        return list;
    }
}
