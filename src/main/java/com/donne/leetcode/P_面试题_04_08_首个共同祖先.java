package com.donne.leetcode;

import com.donne.leetcode.model.TreeNode;

public class P_面试题_04_08_首个共同祖先 {
    public static void main(String[] args) {

    }

    /**
     * 1.如果p 或者 q 是 root 节点 直接返回 root
     * 2.如果p 或者 q 都为 null 直接root
     * 3.如果p 或者 q 有一个为 null 返回不是null的
     * 4.如果p q 分别在root 的两个子树上，那么返回root
     * 5.如果p q 在同一个子树 返回第一个搜索到的p 或者 q
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        if (p == null && q == null) {
            return root;
        }

        if (p == null) {
            return q;
        }

        if (q == null) {
            return p;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //分别在左右子树
        if (left != null && right != null) {
            return root;
        }

        //在左子树
        if (left != null) {
            return left;
        }

        //在右子树
        if (right != null) {
            return right;
        }

        return null;
    }
}
