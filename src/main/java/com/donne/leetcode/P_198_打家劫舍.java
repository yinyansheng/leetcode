package com.donne.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P_198_打家劫舍 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> memo = new HashMap<>();
        return dp(nums, nums.length - 1, memo);
    }

    private static int dp(int[] nums, int x, Map<Integer, Integer> memo) {
        if (memo.containsKey(x)) {
            return memo.get(x);
        }

        if (x == 0) {
            memo.put(x, nums[0]);
            return nums[0];
        }

        if (x == 1) {
            int max = Math.max(nums[0], nums[1]);
            memo.put(x, max);
            return max;
        }

        int max = Math.max(dp(nums, x - 2, memo) + nums[x], dp(nums, x - 1, memo));
        memo.put(x, max);
        return max;
    }
}
