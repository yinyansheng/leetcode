package com.donne.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P_1137_第N个泰波那契数 {
    public static void main(String[] args) {
        Map<Integer, Integer> store = new HashMap<>();
        System.out.println(tib(25, store));
    }

    private static int tib(int n, Map<Integer, Integer> store) {
        if (store.containsKey(n)) {
            return store.get(n);
        }

        int res;
        if (n <= 0) {
            res = 0;
        } else if (1 == n) {
            res = 1;
        } else if (2 == n) {
            res = 1;
        } else {
            res = tib(n - 1, store) + tib(n - 2, store) + tib(n - 3, store);
        }

        store.put(n, res);
        return res;
    }
}
