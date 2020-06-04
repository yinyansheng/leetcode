package com.donne.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_56_数组中数字出现的次数 {
    public static void main(String[] args) {
        int[] ints = singleNumbers2(new int[]{1, 2, 3, 3, 4, 5});
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] singleNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], 1);
            }
        }

        int[] res = new int[map.size()];
        int i = 0;
        for (Integer r : map.keySet()) {
            res[i++] = r;
        }
        return res;
    }

    public static int[] singleNumbers2(int[] nums) {
        //用于将所有的数异或起来
        int k = 0;

        for(int num: nums) {
            k ^= num;
        }

        //获得k中最低位的1
        int mask = 1;

        //mask = k & (-k) 这种方法也可以得到mask，具体原因百度 哈哈哈哈哈
        while((k & mask) == 0) {
            mask <<= 1;
        }

        int a = 0;
        int b = 0;

        for(int num: nums) {
            if((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }

}
