package com.donne.bt;

import com.donne.leetcode.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeDemo {

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

        //prefixOrder(root1);
        //midOrder(root1);
        //postOrder(root1);
        //dfs(root1);
        //bfs(root1);
        //System.out.println(depth(root1));
        //mirror(root1);
        System.out.println(maxVal(root1));
    }

    private static int maxVal(TreeNode root1) {
        if(root1==null){
            return Integer.MIN_VALUE;
        }

        int root = root1.val;
        int leftMax = maxVal(root1.left);
        int rightMax = maxVal(root1.right);
        return Math.max(Math.max(root, leftMax), rightMax);
    }


    /**
     * 翻转二叉树
     *
     * @param root
     */
    private static void mirror(TreeNode root) {
        if (null == root) {
            return;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        mirror(root.right);
        mirror(root.left);

    }

    /**
     * 先序遍历
     *
     * @param root
     */
    private static void prefixOrder(TreeNode root) {
        if (null == root) {
            return;
        }

        System.out.print(root.val);
        prefixOrder(root.left);
        prefixOrder(root.right);
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    private static void midOrder(TreeNode root) {
        if (null == root) {
            return;
        }

        midOrder(root.left);
        System.out.print(root.val);
        midOrder(root.right);
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    private static void postOrder(TreeNode root) {
        if (null == root) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val);
    }

    /**
     * DFS
     *
     * @param root
     */
    private static void dfs(TreeNode root) {
        if (null == root) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.print(pop.val);

            if (null != pop.right) {
                stack.push(pop.right);
            }

            if (null != pop.left) {
                stack.push(pop.left);
            }
        }
    }

    /**
     * BFS
     *
     * @param root
     */
    private static void bfs(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.print(poll.val);
            if (null != poll.left) {
                queue.add(poll.left);
            }

            if (null != poll.right) {
                queue.add(poll.right);
            }
        }
    }

    private static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        return Math.max(leftDepth + 1, rightDepth + 1);
    }
}
