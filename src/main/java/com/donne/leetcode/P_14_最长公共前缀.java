package com.donne.leetcode;

import java.util.Collections;

public class P_14_最长公共前缀 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"asdf", "asd", "as"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (null == strs || 0 == strs.length) {
            return "";
        }

        String lcp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            lcp = longestCommonPrefix(lcp, strs[i]);
        }

        return lcp;
    }

    public static String longestCommonPrefix(String a, String b) {
        if (null == a || "".equals(a)) {
            return "";
        }

        if (null == b || "".equals(b)) {
            return "";
        }

        int ptr = 0;
        while (ptr < a.length() && ptr < b.length()) {
            if (a.charAt(ptr) == b.charAt(ptr)) {
                ptr++;
                continue;
            }
            break;
        }

        return a.substring(0, ptr);
    }
}
