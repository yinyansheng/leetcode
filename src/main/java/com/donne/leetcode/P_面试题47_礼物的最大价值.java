package com.donne.leetcode;

import java.util.Map;

public class P_面试题47_礼物的最大价值 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        int[][] dp = new int[grid.length + 1][grid[0].length + 1];

        for (int i = 1; i <= grid.length; i++) {
            for (int j = 1; j <= grid[i-1].length; j++) {
                System.out.println(i + "--" + j);
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }

        System.out.println(dp[grid.length][grid[0].length]);

    }


    /**
     * //dp[i][j]=max(dp[i-1][j],dp[i,j-1])+grid[i][j];
     *
     * @param grid
     * @param x
     * @param y
     * @return
     */
    private static int dp(int[][] grid, int x, int y) {
        if (x < 0 || y < 0) {
            return 0;
        }

        return Math.max(dp(grid, x - 1, y), dp(grid, x, y - 1)) + grid[x][y];
    }
}
