package com.donne.leetcode;

public class P_121_买卖股票的最佳时机 {
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        //System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int minPrices = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minPrices;
            maxProfit = Math.max(profit, maxProfit);

            if (prices[i] < minPrices) {
                minPrices = prices[i];
            }
        }
        return maxProfit;

    }

}
