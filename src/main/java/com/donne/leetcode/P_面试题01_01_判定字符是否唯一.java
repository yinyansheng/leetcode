package com.donne.leetcode;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-22
 */
public class P_面试题01_01_判定字符是否唯一 {
    public static void main(String[] args) {
        System.out.println(isUnique("ab"));
    }

    public static boolean isUnique(String astr) {
        long bitMap0 = 0L;
        long bitMap1 = 0L;

        for (char c : astr.toCharArray()) {
            if (c > 64) {
                long index0 = 1L << (c - 64);
                if ((bitMap0 & index0) > 0) {
                    return false;
                }
                bitMap0 = bitMap0 | index0;
            } else {
                long index1 = 1L << c;
                if ((bitMap1 & index1) > 0) {
                    return false;
                }
                bitMap1 = bitMap1 | index1;
            }
        }

        return true;
    }
}
