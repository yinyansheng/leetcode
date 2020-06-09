package com.donne.leetcode;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-09
 */
public class P_面试题46_把数字翻译成字符串 {
    public static void main(String[] args) {
        System.out.println(translateNum("506".toCharArray(), 0));
    }

    public static int translateNum(char[] chars, int start) {
        //corner case
        if (start >= chars.length - 1) {
            return 1;
        }

        //如果当前字符 c>2 || （c=2 && nc>=0 && nc<=5）
        char curr = chars[start];
        char next = chars[start + 1];
        if (curr > '2' || (curr == '2' && next > '5') || curr=='0') {
            return translateNum(chars, start + 1);
        }

        return translateNum(chars, start + 1) + translateNum(chars, start + 2);
    }
}
