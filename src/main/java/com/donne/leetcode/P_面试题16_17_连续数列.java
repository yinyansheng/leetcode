package com.donne.leetcode;

public class P_面试题16_17_连续数列 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        //dp[i] 表示含第i个元素的最大连续值
        //if(dp[i-1]<0) dp[i]=nums[i]
        //if(dp[i-1]>=0) dp[i]=nums[i]+dp[i-1]

        int ans = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
