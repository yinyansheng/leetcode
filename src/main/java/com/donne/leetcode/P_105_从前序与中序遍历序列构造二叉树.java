package com.donne.leetcode;

import com.donne.leetcode.model.TreeNode;

public class P_105_从前序与中序遍历序列构造二叉树 {
    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};

        TreeNode treeNode = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
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
