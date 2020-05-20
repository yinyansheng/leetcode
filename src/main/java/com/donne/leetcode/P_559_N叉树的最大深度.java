package com.donne.leetcode;

import com.donne.leetcode.model.Node;

public class P_559_N叉树的最大深度 {
    public static void main(String[] args) {

    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int ans = 0;
        for (Node node : root.children) {
            ans = Math.max(ans, maxDepth(node));
        }
        return 1 + ans;
    }
}
