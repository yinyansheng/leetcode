package com.donne.temp;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-04
 */
public class T {

    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        //corner case
        if (null == nums || 0 == nums.length) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;

        int ans = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i]=1;
            for (int j = 0; j <= i - 1; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }


        return ans;
    }
}
