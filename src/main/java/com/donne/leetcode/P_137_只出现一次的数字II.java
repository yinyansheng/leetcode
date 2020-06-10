package com.donne.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-10
 */
public class P_137_只出现一次的数字II {
    public static void main(String[] args) {
        int[] nums = new int[]{43, 16, 45, 89, 45, -2147483648, 45, 2147483646, -2147483647, -2147483648, 43, 2147483647, -2147483646, -2147483648, 89, -2147483646, 89, -2147483646, -2147483647, 2147483646, -2147483647, 16, 16, 2147483646, 43};

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        System.out.println(map.entrySet().stream().filter(r -> r.getValue() == 1).findFirst().get().getKey());
    }
}
