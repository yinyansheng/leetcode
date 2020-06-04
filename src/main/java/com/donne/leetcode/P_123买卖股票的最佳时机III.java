package com.donne.leetcode;

public class P_123买卖股票的最佳时机III {
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int k = 2;

        if (0 == n) {
            return 0;
        }

        //dp[i][k][0] 第i天 最多经过k次的交易 不持有彩票 的最大利润
        int[][][] dp = new int[n][k + 1][2];

        //init base case
        //dp[0][k][0]=0 第0天不持有股票
        //dp[0][k][1]=-prices[0] 第0天持有股票 -prices[i]
        //dp[i][0][0]=0 经过0次交易 利润为0
        //dp[i][0][1]=Integer.minValue 不可能

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = Integer.MIN_VALUE;
                    continue;
                }

                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[0];
                    continue;
                }

                //第i天不持有股票转移方程
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                //第天持有股票的转移方程
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        return dp[n - 1][k][0];
    }
}
