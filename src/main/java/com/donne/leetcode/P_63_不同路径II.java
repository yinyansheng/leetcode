package com.donne.leetcode;

public class P_63_不同路径II {
    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int i = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(i);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        dp[0][0] = 1;

        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                if (obstacleGrid[i][j] == 1) {
                    continue;
                }

                int up = 0;
                int left = 0;

                if (i - 1 >= 0 && obstacleGrid[i - 1][j] != 1) {
                    up = dp[i - 1][j];
                }

                if (j - 1 >= 0 && obstacleGrid[i][j - 1] != 1) {
                    left = dp[i][j - 1];
                }

                dp[i][j] = up + left;
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];

    }
}
