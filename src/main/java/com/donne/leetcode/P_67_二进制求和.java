package com.donne.leetcode;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-23
 */
public class P_67_二进制求和 {
    public static void main(String[] args) {
        System.out.println(addBinary("111", "11"));
    }

    /**
     * 111
     * 11
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;

        String ans = "";
        int pre = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                pre += a.charAt(i) - '0';
            }

            if (j >= 0) {
                pre += b.charAt(j) - '0';
            }

            ans = pre % 2 + ans;
            pre = pre / 2;

            i--;
            j--;
        }

        if (pre > 0) {
            ans = pre + ans;
        }

        return ans;
    }
}
