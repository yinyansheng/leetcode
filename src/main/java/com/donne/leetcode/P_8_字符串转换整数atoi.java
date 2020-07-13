package com.donne.leetcode;

/**
 * @Author: yinyansheng
 * @Date: 2020-07-13
 */
public class P_8_字符串转换整数atoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("9223372036854775808"));
        //System.out.println(myAtoi("42"));
//        System.out.println(myAtoi("  -42"));
//        System.out.println(myAtoi("4193 with words"));
    }

    public static int myAtoi(String str) {
        long ans = 0L;
        boolean symbol = false;
        boolean number = false;
        long symbolFlag = 1;
        for (char c : str.toCharArray()) {
            if (!symbol && !number && c == ' ') {
                continue;
            }

            if (c == '-' || c == '+') {
                if (symbol) {
                    return 0;
                }
                symbolFlag = c == '-' ? -1 : 1;
                symbol = true;
                continue;
            }

            if (c >= '0' && c <= '9') {
                ans = ans * 10 + (c - '0');
                number = true;
                continue;
            }

            break;
        }


        if (ans > 0) {
            return ans > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) ans;
        }

        return ans < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) ans;
    }
}
