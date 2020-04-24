package com.donne.leetcode;

public class P_7_整数反转 {

    public static void main(String[] args) {
        System.out.println(reverse(0, 123));
    }

    public static int reverse(int res, int x) {
        if (Math.abs(x) < 10) {
            return res * 10 + x;
        }
        return reverse(res * 10 + x % 10, x / 10);
    }
}
