package com.donne.leetcode;

import java.util.Arrays;

public interface P_面试题01_04_回文排列 {
    public static void main(String[] args) {
        boolean tactcoa = canPermutePalindrome("aabc");
        System.out.println(tactcoa);
    }

    public static boolean canPermutePalindrome(String s) {
        int[] table = new int[256];

        int oddCount = 0;
        for (char c : s.toCharArray()) {
            if ((table[c]++ & 1) == 1) {
                oddCount--;
            } else {
                oddCount++;
            }
        }

        return oddCount <= 1;

    }
}
