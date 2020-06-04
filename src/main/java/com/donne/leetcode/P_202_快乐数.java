package com.donne.leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_202_快乐数 {

    public static void main(String[] args) {
        System.out.println(isHappy(8));
    }


    private static Set<Integer> set = new HashSet<>();

    public static boolean isHappy(int n) {
        System.out.println(n);
        if (n == 1) {
            return true;
        }

        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }

        if (set.contains(sum)) {
            return false;
        }

        set.add(sum);
        return isHappy(sum);
    }
}
