package com.donne.leetcode;

public class P_91_解码方法 {
    public static void main(String[] args) {
        System.out.println(numDecodings("01"));
    }

    public static int numDecodings(String s) {
        if(s.startsWith("0")){
            return 0;
        }
        return decode(s.toCharArray(), s.length() - 1);
    }

    static int decode(char[] chars, int index) {
        if (index <= 0) {
            return 1;
        }

        char curr = chars[index];
        char prev = chars[index - 1];

        int count = 0;
        if (curr > '0') {
            count += decode(chars, index - 1);
        }

        if (prev == '1' || (curr <= '6' && prev == '2')) {
            count += decode(chars, index - 2);
        }

        return count;
    }
}
