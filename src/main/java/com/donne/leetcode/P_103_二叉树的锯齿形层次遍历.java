package com.donne.leetcode;

import com.donne.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P_103_二叉树的锯齿形层次遍历 {
    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};

        TreeNode treeNode = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        List<List<Integer>> lists = zigzagLevelOrder(treeNode);

    }


    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        for (int i = 0; i < result.size(); i++) {
            if (i % 2 == 1) {
                Collections.reverse(result.get(i));
            }
        }
        return result;
    }

    private static void dfs(TreeNode root, int depth, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        if (result.size() - 1 < depth) {
            result.add(new ArrayList<>(Collections.singletonList(root.val)));
        } else {
            result.get(depth).add(root.val);
        }

        dfs(root.left, depth + 1, result);
        dfs(root.right, depth + 1, result);
    }


    public static TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }

        //根为前序遍历的第一个元素
        TreeNode root = new TreeNode(preorder[preLeft]);

        //中序遍历根的位置
        int inorderRootIndex = getIndex(inorder, inLeft, inRight, root.val);

        root.left = buildTree(preorder, preLeft + 1, preLeft + inorderRootIndex - inLeft, inorder, inLeft, inorderRootIndex - 1);
        root.right = buildTree(preorder, preLeft + inorderRootIndex - inLeft + 1, preRight, inorder, inorderRootIndex + 1, inRight);
        return root;
    }

    private static int getIndex(int[] inorder, int inLeft, int inRight, int target) {
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }

        throw new RuntimeException();
    }


}
