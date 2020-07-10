package com.donne.leetcode;

import java.util.Arrays;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-22
 */
public class P_面试题0_02_判定是否互为字符重排 {
    public static void main(String[] args) {

    }

    public boolean CheckPermutation(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return new String(chars1).equals(new String(chars2));
    }
}
