package com.donne.leetcode;

public class P_392_子序列 {

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "bcbvvc"));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0 && t.length() == 0) {
            return true;
        }

        if (s.length() == 0) {
            return true;
        }

        if (t.length() == 0) {
            return false;
        }

        int ptrs = 0;
        int ptrt = 0;

        while (ptrs < s.length()) {
            if (s.charAt(ptrs) == t.charAt(ptrt)) {
                ptrs++;
            }

            ptrt++;

            if (ptrs == s.length()) {
                return true;
            }

            if (ptrt == t.length()) {
                return false;
            }

        }
        return false;
    }
}