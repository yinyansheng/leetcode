package com.donne.leetcode;

/**
 * https://leetcode-cn.com/problems/powx-n/
 */
public class P_平方数 {
    public static void main(String[] args) {
        System.out.println(myPow2(2.00000, -2147483648));
    }

    /**
     * 递归 + 二分
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow2(double x, int n) {
        if (n < 0) {
            x = 1 / x;
        }

        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        double half = myPow2(x, Math.abs(n / 2));
        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }

    /**
     * 递归
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        System.out.println(String.format("%S-%S", x, n));

        if (n == 1) {
            return x;
        }

        return x * myPow(x, n - 1);
    }
}
