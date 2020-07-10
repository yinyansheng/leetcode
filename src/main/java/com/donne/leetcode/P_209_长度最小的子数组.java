package com.donne.leetcode;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-28
 */
public class P_209_长度最小的子数组 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        System.out.println(minSubArrayLen(5, nums));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        int l = 0;
        int r = 0;
        int ans = Integer.MAX_VALUE;

        while (l <= r && l < nums.length && r < nums.length) {
            int sum = 0;
            for (int i = l; i <= r; i++) {
                sum += nums[i];
            }

            if (sum >= s) {
                ans = Math.min(ans, r - l + 1);
                l++;
                continue;
            }

            r++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}
