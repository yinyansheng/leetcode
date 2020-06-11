package com.donne.leetcode;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-10
 */
public class P_5_最长回文子串 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        String ans = "";
        for (int i = 0; i < chars.length; i++) {
            String palindromeEven = longestPalindrome(s, i, false);
            String palindromeOdd = longestPalindrome(s, i, true);

            if (ans.length() < palindromeEven.length()) {
                ans = palindromeEven;
            }

            if (ans.length() < palindromeOdd.length()) {
                ans = palindromeOdd;
            }
        }

        return ans;
    }

    /**
     * 中心扩展法
     * 奇数
     * 偶数第一位
     *
     * @param i
     * @return
     */
    private static String longestPalindrome(String s, int i, boolean odd) {
        int left = i - (odd ? 1 : 0);
        int right = i + 1;

        //奇数回文串
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                continue;
            }
            break;
        }

        return s.substring(left + 1, right);
    }


}
