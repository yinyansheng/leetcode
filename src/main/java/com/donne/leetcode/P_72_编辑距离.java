package com.donne.leetcode;

public class P_72_编辑距离 {

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }

    public static int minDistance(String word1, String word2) {
        //judge corner case
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        //初始化dp[i][0]=i ;dp[0][i]=i;
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int update = dp[i - 1][j - 1] + 1;
                    int delete = dp[i - 1][j] + 1;
                    int insert = dp[i][j - 1] + 1;
                    dp[i][j] = Math.min(Math.min(update, delete), insert);
                }
            }
        }

        return dp[m][n];
    }


}
