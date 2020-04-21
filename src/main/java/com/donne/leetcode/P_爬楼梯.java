package com.donne.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P_爬楼梯 {
    public static void main(String[] args) {
        System.out.println(climbStairs(10));
    }


    public static int climbStairs(int n) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        return climbStairs(n, resultMap);
    }

    public static int climbStairs(int n, Map<Integer, Integer> resultMap) {
        if (resultMap.containsKey(n)) {
            return resultMap.get(n);
        }

        int result;
        if (n == 1) {
            result = 1;
        } else if (n == 2) {
            result = 2;
        } else {
            result = climbStairs(n - 1, resultMap) + climbStairs(n - 2, resultMap);
        }

        resultMap.put(n, result);
        return result;
    }


}
