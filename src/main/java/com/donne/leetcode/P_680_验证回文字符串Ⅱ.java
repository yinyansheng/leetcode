package com.donne.leetcode;

public class P_680_验证回文字符串Ⅱ {

    public static void main(String[] args) {
        System.out.println(validPalindrome("abad".toCharArray(), 0, 3, 1));
    }

    public static boolean validPalindrome(char[] chars, int low, int high, int times) {
        if (times < 0) {
            return false;
        }

        while (low < high) {
            if (chars[low] != chars[high]) {
                return validPalindrome(chars, low + 1, high, times - 1) || validPalindrome(chars, low, high - 1, times - 1);
            }

            low++;
            high--;
        }

        return true;
    }


}
