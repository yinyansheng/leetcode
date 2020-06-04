package com.donne.leetcode;

public class P_198_打家劫舍2 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 1, 2};

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        int max = Math.max(dp[0], dp[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

}
