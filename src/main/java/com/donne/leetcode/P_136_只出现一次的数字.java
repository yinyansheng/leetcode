package com.donne.leetcode;

public class P_136_只出现一次的数字 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 1, 3, 4, 4}));
    }

    public static int singleNumber(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            a ^= nums[i];
        }
        return a;
    }
}
