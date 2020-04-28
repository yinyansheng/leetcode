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
        //所有数抑或
        int x = nums[0];
        for (int i = 1; i < nums.length; i++) {
            x ^= nums[i];
        }

        //获取某一位 为1的值
        //int lowBit = x & (-x);
        //获得k中最低位的1
        int mask = 1;

        //mask = k & (-k) 这种方法也可以得到mask，具体原因百度 哈哈哈哈哈
        while((x & mask) == 0) {
            mask <<= 1;
        }

        //按该位置分成两组 分别全抑或操作，则得到这两个数
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & mask) == 0) {
                res[0] ^= nums[i];
            } else {
                res[1] ^= nums[i];
            }
        }

        return res;
    }

}
