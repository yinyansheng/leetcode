package com.donne.leetcode;

/**
 * @Author: yinyansheng
 * @Date: 2020-07-15
 */
public class P_96_不同的二叉搜索树 {
    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
