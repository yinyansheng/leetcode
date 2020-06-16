package com.donne.leetcode;

import com.donne.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-16
 */
public class P_297_二叉树的序列化与反序列化 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        Codec codec = new Codec();
        String serialize = codec.serialize(root);
        TreeNode deserialize = codec.deserialize(serialize);
    }


}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        serialize(root, list);
        return list.stream().map(String::valueOf).collect(Collectors.joining(","));
    }

    private void serialize(TreeNode root, List<String> list) {
        if (root == null) {
            list.add("&");
            return;
        }

        list.add(String.valueOf(root.val));
        serialize(root.left, list);
        serialize(root.right, list);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = Arrays.stream(data.split(",")).collect(Collectors.toList());
        return deserialize(list);
    }

    private TreeNode deserialize(List<String> list) {
        String val = list.get(0);
        if ("&".equals(val)) {
            list.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val));
        list.remove(0);
        root.left = deserialize(list);
        root.right = deserialize(list);

        return root;
    }
}
