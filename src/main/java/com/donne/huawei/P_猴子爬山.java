package com.donne.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P_猴子爬山 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        Map<Integer, Integer> memo = new HashMap<>();
        System.out.println(f(size, memo));
    }

    /**
     * 每次只能爬1步 或者3步
     *
     * @param size
     * @return
     */
    private static int f(int size, Map<Integer, Integer> memo) {
        if (memo.containsKey(size)) {
            return memo.get(size);
        }

        if (size < 0) {
            return 0;
        }

        if (size == 1 || size == 2) {
            return 1;
        }

        if (size == 3) {
            return 2;
        }

        int count = f(size - 1, memo) + f(size - 3, memo);
        memo.put(size, count);
        return count;
    }
}
