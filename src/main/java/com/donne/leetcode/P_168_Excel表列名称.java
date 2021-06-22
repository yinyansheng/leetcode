package com.donne.leetcode;

public class P_168_Excel表列名称 {
    public static void main(String[] args) {
        System.out.printf(convertToTitle(701));
    }

    public static String convertToTitle(int columnNumber) {
        int tmp = columnNumber;
        String result = "";
        while (tmp > 0) {
            int current = tmp % 26;
            if (current == 0) {
                current = 26;
                tmp = tmp - 26;
            }

            result = String.format("%s%s", (char) ('A' + current - 1), result);

            tmp = tmp / 26;
        }

        return result;
    }
}
