package com.donne.newcoder;

import java.util.Scanner;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-04
 */
public class P_等差数列 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                int sum = 2;
                int item = 2;

                for (int i = 0; i < n - 1; i++) {
                    item += 3;
                    sum += item;
                }

                System.out.println(sum);
            }
        } catch (Exception ex) {
            System.out.println(-1);
        }
    }
}
