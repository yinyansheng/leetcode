package com.donne.leetcode;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-10
 */
public class P_1470_重新排列数组 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 1, 3, 4, 7};
        int[] shuffle = shuffle(nums, 3);
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < n; i++) {
            ans[2 * i + 1] = nums[n + i];
            ans[2 * i] = nums[i];
        }

        return ans;
    }
}
