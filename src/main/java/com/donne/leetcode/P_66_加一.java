package com.donne.leetcode;


import java.util.Arrays;

public class P_66_加一 {

    public static void main(String[] args) {
        int[] source = new int[]{8, 9, 9, 9};
        Arrays.stream(plusOne(source)).forEach(System.out::println);
    }

    public static int[] plusOne(int[] digits) {
        int p = -1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (-1 == p) {
                int tmp = digits[i];
                p = (tmp + 1) / 10;
                digits[i] = (tmp + 1) % 10;
            } else {
                int tmp = digits[i];
                digits[i] = (p + tmp) % 10;
                p = (p + tmp) / 10;
            }

            if(p==0){
                return digits;
            }
        }

        if (0 == p) {
            return digits;
        }

        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = p;
        System.arraycopy(digits, 0, newDigits, 1, digits.length);
        return newDigits;
    }
}