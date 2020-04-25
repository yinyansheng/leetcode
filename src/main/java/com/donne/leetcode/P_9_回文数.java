package com.donne.leetcode;

public class P_9_回文数 {

    public static void main(String[] args) {

        System.out.println(
                isPalindrome(12021)
        );
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        //翻转这个数
        int tmp = 0;
        int tx = x;
        while (tx > 0) {
            tmp = tmp * 10 + tx % 10;
            tx = tx / 10;
        }

        tmp += tx;
        return tmp == x;
    }
}
