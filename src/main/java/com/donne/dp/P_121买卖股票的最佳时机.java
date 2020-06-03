package com.donne.dp;

public class P_121买卖股票的最佳时机 {
    public static void main(String[] args) {

    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;

        if (n == 0) {
            return 0;
        }

        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][1] = -prices[0];
                dp[i][0] = 0;
                continue;
            }

            dp[i][0] = Math.max(
                    dp[i - 1][0],
                    dp[i - 1][1] + prices[i]
            );
            dp[i][1] = Math.max(
                    dp[i - 1][0] - prices[i],
                    dp[i - 1][1]
            );
        }

        return dp[n - 1][0];
    }

}
