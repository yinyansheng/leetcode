package com.donne.leetcode;

public class P_43_字符串相乘 {
    public static void main(String[] args) {
        System.out.println(multiply("11", "11"));
    }

    public static String multiply(String num1, String num2) {
        int ans = 0;
        int w = 1;
        for (int j = num2.length() - 1; j >= 0; j--) {
            Integer multiply = multiply(num1, num2.charAt(j) - '0');
            ans += w * multiply;
            w *= 10;
        }

        return ans + "";
    }

    private static Integer multiply(String num1, Integer m) {
        int p = 0;
        int ans = 0;
        int w = 1;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int x = (num1.charAt(i) - '0') * m + p;
            ans = (x % 10) * w + ans;
            p = x / 10;
            w *= 10;
        }
        return p * w + ans;
    }


}
