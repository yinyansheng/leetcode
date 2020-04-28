package com.donne.dp;

import java.util.HashMap;
import java.util.Map;

public class 最长递增子序列 {
    public static void main(String[] args) {
        Map<Integer, Integer> memo = new HashMap<>();
        int[] nums = new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6};
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, dp(i, nums, memo));
        }
        System.out.println(max);
    }

    /**
     * i=0 return 1;
     * dp(i)= max{dp(x)+num[x]<num[x]?1:0} x in {0,i-1}
     *
     * @param i
     * @param nums
     * @return
     */
    private static int dp(int i, int[] nums, Map<Integer, Integer> memo) {
        if (nums.length == 0) {
            return 0;
        }

        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        if (i == 0) {
            memo.put(i, 1);
            return 1;
        }

        int max = 1;
        for (int j = 0; j <= i - 1; j++) {
            if (nums[j] < nums[i]) {
                int dp = dp(j, nums, memo) + 1;
                max = Math.max(max, dp);
            }
        }

        memo.put(i, max);
        return max;
    }

}
