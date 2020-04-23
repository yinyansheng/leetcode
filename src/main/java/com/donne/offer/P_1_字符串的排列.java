package com.donne.offer;

public class P_1_字符串的排列 {
    public static void main(String[] args) {
        permutation("abc".toCharArray(), 0, 2);
    }


    /**
     * abc
     * <p>
     * a bc
     * b ac
     * c ab
     */
    private static void permutation(char[] chars, int from, int to) {
        if (from == to) {
            System.out.println(chars);
            return;
        }

        for (int i = from; i <= to; i++) {
            swap(chars, from, i);
            permutation(chars, from + 1, to);
            swap(chars, from, i);
        }
    }


    private static void swap(char[] chars, Integer from, Integer to) {
        char tmp = chars[from];
        chars[from] = chars[to];
        chars[to] = tmp;
    }


}
