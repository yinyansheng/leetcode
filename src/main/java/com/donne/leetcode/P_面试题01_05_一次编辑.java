package com.donne.leetcode;

/**
 * @Author: yinyansheng
 * @Date: 2020-07-02
 */
public class P_面试题01_05_一次编辑 {
    public static void main(String[] args) {
        System.out.println(editDistance("abc", "abc"));
    }

    public static boolean editDistance(String first, String second) {
        char[] chars0 = first.toCharArray();
        char[] chars1 = second.toCharArray();

        int[][] dp = new int[chars0.length + 1][chars1.length + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (chars0[i - 1] == chars1[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }

                int update = dp[i - 1][j - 1] + 1;
                int insert = dp[i][j - 1] + 1;
                int delete = dp[i - 1][j] + 1;
                dp[i][j] = Math.min(Math.min(update, insert), delete);
            }
        }

        return dp[chars0.length][chars1.length] <= 1;
    }
}
