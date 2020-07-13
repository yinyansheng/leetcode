package com.donne.leetcode;

/**
 * @Author: yinyansheng
 * @Date: 2020-07-13
 */
public class P_44_通配符匹配 {
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
    }

    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        dp[0][0] = true;
        /**
         * dp[0][x] 只有一种情况 即X全位* 为true,其余为false
         * 例如 “” 和 “*”，“***”
         */
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                int dpi = i + 1;
                int dpj = j + 1;

                if (p.charAt(j) != '*') {
                    if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
                        dp[dpi][dpj] = dp[dpi - 1][dpj - 1];
                    }
                } else {
                    dp[dpi][dpj] = dp[dpi][dpj - 1] || dp[dpi - 1][dpj];
                }
            }
        }

        return dp[s.length()][p.length()];
    }


}
