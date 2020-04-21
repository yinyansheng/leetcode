package com.donne.leetcode;

/**
 * https://leetcode-cn.com/problems/ugly-number/
 */
public class P_丑数 {

    public static void main(String[] args) {
        System.out.println(isUgly(127));
    }

    /**
     * 2,3,5
     *
     * @param num
     * @return
     */
    public static boolean isUgly(int num) {
        if (0 == num) {
            return false;
        }

        if (1 == num) {
            return true;
        }

        if (num % 2 == 0) {
            return isUgly(num / 2);
        }

        if (num % 3 == 0) {
            return isUgly(num / 3);
        }

        if (num % 5 == 0) {
            return isUgly(num / 5);
        }

        return false;
    }
}
