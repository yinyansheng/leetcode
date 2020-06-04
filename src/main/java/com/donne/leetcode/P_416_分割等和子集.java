package com.donne.leetcode;

import java.util.Arrays;

public class P_416_分割等和子集 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(new P_416_分割等和子集().canPartition(nums));

    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }

        return sum / 2 == dp(nums, sum / 2, nums.length - 1);
    }

    public int dp(int[] nums, int sum, int i) {
        if (i < 0) {
            return 0;
        }

        if (nums[i] > sum) {
            return dp(nums, sum, i - 1);
        }

        return Math.max(
                dp(nums, sum, i - 1),
                dp(nums, sum - nums[i], i - 1) + nums[i]
        );
    }

}
