package com.donne.leetcode;

/**
 * @Author: yinyansheng
 * @Date: 2020-07-14
 */
public class P_10_正则表达式匹配 {

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a*"));
    }

    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                int dpi = i + 1;
                int dpj = j + 1;

                if (p.charAt(j) != '*') {
                    if (match(s.charAt(i), p.charAt(j))) {
                        dp[dpi][dpj] = dp[dpi - 1][dpj - 1];
                    }
                } else {
                    dp[dpi][dpj] = dp[dpi][dpj - 2];
                    if (match(s.charAt(i), p.charAt(j - 1))) {
                        dp[dpi][dpj] = dp[dpi - 1][dpj] || dp[dpi][dpj - 2];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    private static boolean match(char si, char pj) {
        if ('.' == pj) {
            return true;
        }

        return si == pj;
    }
}
