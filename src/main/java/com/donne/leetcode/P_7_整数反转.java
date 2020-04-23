package com.donne.leetcode;

public class P_7_整数反转 {

    public static void main(String[] args) {
        System.out.println(reverse(0, -2147483648));
    }

    public static int reverse(int res, int x) {
        if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
            return 0;
        }

        if (Math.abs(x) < 10) {
            return res * 10 + x;
        }
        return reverse(res * 10 + x % 10, x / 10);
    }
}
