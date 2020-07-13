package com.donne.leetcode;

/**
 * @Author: yinyansheng
 * @Date: 2020-07-13
 */
public class P_面试题17_13_恢复空格 {
    /**
     * ["potimzz"]
     * "potimzzpotimzz"
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] dictionary = new String[]{"potimzz"};
        String sentence = "potimzzpotimzz";
        int respace = respace(dictionary, sentence);
        System.out.println(respace);
    }

    public static int respace(String[] dictionary, String sentence) {
        int[] dp = new int[sentence.length() + 1];

        for (int i = 0; i < sentence.length(); i++) {
            int dpi = i + 1;
            dp[dpi] = dp[dpi - 1];

            for (String word : dictionary) {
                if (word.length() > i + 1) {
                    continue;
                }

                String sub = sentence.substring(i + 1 - word.length(), i + 1);
                if (sub.equals(word)) {
                    dp[dpi] = Math.max(dp[dpi], word.length() + dp[dpi - word.length()]);
                }
            }
        }

        return sentence.length() - dp[sentence.length()];
    }
}
