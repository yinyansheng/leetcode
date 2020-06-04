package com.donne.leetcode;

public class P_152_乘积最大子数组 {
    public static void main(String[] args) {

    }

    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imin;
                imin = imax;
                imax = tmp;
            }

            imin = Math.min(nums[i] * imin, nums[i]);
            imax = Math.max(nums[i] * imax, nums[i]);

            max = Math.max(max, imax);
        }

        return max;
    }
}
