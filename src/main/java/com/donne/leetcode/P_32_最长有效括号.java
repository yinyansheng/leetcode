package com.donne.leetcode;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-28
 */
public class P_32_最长有效括号 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(())"));
    }

    public static int longestValidParentheses(String s) {
        int ans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')' && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
            }

            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                dp[i] = Math.max(dp[i], i - 2 >= 0 ? (dp[i - 2] + 2) : 2);
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

}
