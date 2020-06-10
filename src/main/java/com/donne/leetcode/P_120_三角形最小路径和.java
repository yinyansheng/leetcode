package com.donne.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-10
 */
public class P_120_三角形最小路径和 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3));

        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];

        //corner case
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = triangle.get(0).get(0);


        //dp[i][j]=min{dp[i-1][j],dp[i-1][j-1]}+data[i][j]
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j <= i; j++) {
                int dp1 = dp[i - 1][j];
                int dp2 = Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    dp2 = dp[i - 1][j - 1];
                }

                dp[i][j] = Math.min(dp1, dp2) + triangle.get(i).get(j);
            }
        }

        return Arrays.stream(dp[triangle.size() - 1]).min().getAsInt();
    }
}
