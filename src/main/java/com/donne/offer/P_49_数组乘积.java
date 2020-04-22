package com.donne.offer;

import java.util.Arrays;

public class P_49_数组乘积 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int[] ints = multipleArray(nums);

        Arrays.stream(ints).forEach(System.out::println);
    }

    private static int[] multipleArray(int[] nums) {
        //右侧数组
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = 1;
            for (int j = 0; j < i; j++) {
                result[i] *= nums[j];
            }

            for (int j = i + 1; j < nums.length; j++) {
                result[i] *= nums[j];
            }
        }

        return result;
    }

}
