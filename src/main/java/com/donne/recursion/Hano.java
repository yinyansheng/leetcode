package com.donne.recursion;

public class Hano {
    public static void main(String[] args) {
        hn('A', 'B', 'C', 3);
    }

    /**
     * 将N个盘子 从A 借助 B 放到C 上
     *
     * @param a
     * @param b
     * @param c
     * @param n
     */
    private static void hn(char a, char b, char c, int n) {
        if (n > 0) {
            //先将N-1个 从A 借助C 放到B 上
            hn(a, c, b, n - 1);
            //将n从A 放到C上
            System.out.println(String.format("%s -> %s", a, c));
            //将B的N-1 通过A 放到C上
            hn(b, a, c, n - 1);
        }
    }
}
