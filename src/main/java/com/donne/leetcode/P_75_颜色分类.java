package com.donne.leetcode;

import java.util.Arrays;

public class P_75_颜色分类 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 0, 1, 0, 2, 2};
        sortColors(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void sortColors(int[] nums) {
        int a = 0;
        int b = 0;
        int c = 0;

        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    a++;
                    break;
                case 1:
                    b++;
                    break;
                case 2:
                    c++;
                    break;
                default:
                    throw new IllegalArgumentException("invalid parameters");
            }
        }

        for (int i = 0; i < a; i++) {
            nums[i] = 0;
        }

        for (int i = a; i < a + b; i++) {
            nums[i] = 1;
        }

        for (int i = a + b; i < a + b + c; i++) {
            nums[i] = 2;
        }
    }
}
