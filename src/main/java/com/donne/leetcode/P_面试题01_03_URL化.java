package com.donne.leetcode;

/**
 * @Author: yinyansheng
 * @Date: 2020-07-02
 */
public class P_面试题01_03_URL化 {
    public static void main(String[] args) {
        String s = replaceSpaces("ds sdfs afs sdfa dfssf asdf             ", 27);
    }

    public static String replaceSpaces(String S, int length) {
        int p0 = length - 1;
        int p1 = S.length() - 1;
        char[] chars = S.toCharArray();
        while (p0 >= 0) {
            char tmp=chars[p0];
            chars[p0]=' ';
            if (tmp == ' ') {
                chars[p1 - 2] = '%';
                chars[p1 - 1] = '2';
                chars[p1] = '0';
                p1 -= 3;
            } else {
                chars[p1] = tmp;
                p1 -= 1;
            }
            p0--;
        }

        return new String(chars).replace(" ","");
    }
}
