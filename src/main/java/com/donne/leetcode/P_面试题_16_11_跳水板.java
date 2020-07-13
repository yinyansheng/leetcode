package com.donne.leetcode;

/**
 * @Author: yinyansheng
 * @Date: 2020-07-13
 */
public class P_面试题_16_11_跳水板 {
    public static void main(String[] args) {

    }

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }

        if (shorter == longer) {
            return new int[]{shorter * k};
        }

        int[] lengths = new int[k + 1];

        for (int i = 0; i <= k; i++) {
            lengths[i] = longer * i + shorter * (k - i);
        }

        return lengths;
    }
}
