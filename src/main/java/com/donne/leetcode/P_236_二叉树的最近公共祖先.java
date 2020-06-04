package com.donne.leetcode;

import com.donne.leetcode.model.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_236_二叉树的最近公共祖先 {
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

        TreeNode treeNode = lowestCommonAncestor(root1, root5, root6);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == q) {
            return p;
        }

        parentMap.put(root, null);
        dfs(root);

        while (parentMap.containsKey(p)) {
            visitMap.put(p, 1);
            p = parentMap.get(p);
        }

        while (parentMap.containsKey(q)) {
            if (visitMap.containsKey(q)) {
                return q;
            }
            q = parentMap.get(q);
        }

        return null;
    }

    static Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    static Map<TreeNode, Integer> visitMap = new HashMap<>();

    private static void dfs(TreeNode root) {
        if (null == root) {
            return;
        }

        if (root.left != null) {
            parentMap.put(root.left, root);
            dfs(root.left);
        }

        if (root.right != null) {
            parentMap.put(root.right, root);
            dfs(root.right);
        }
    }
}
