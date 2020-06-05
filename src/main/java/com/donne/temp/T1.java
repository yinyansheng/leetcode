package com.donne.temp;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-05
 */
public class T1 {
    public static void main(String[] args) {
        int n = 7;
        int count = 0;

        do {
            count += n % 2;
            n >>= 1;
        } while (n > 0);

        System.out.println(count);
    }
}
