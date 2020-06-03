package com.donne.newcoder;

import java.util.Scanner;

public class P_最小公倍数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer first = scanner.nextInt();
        Integer second = scanner.nextInt();
        System.out.println(first * second / gcd(first, second));
    }


    /**
     * 最小公约数
     *
     * @param a
     * @param b
     * @return 最小公约数
     */
    private static Integer gcd(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        if (0 == a % b) {
            return b;
        }

        return gcd(b, a % b);
    }
}
