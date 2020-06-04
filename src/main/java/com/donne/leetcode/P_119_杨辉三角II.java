package com.donne.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_119_杨辉三角II {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            int f = f(4, i, map);
            System.out.print(f);
        }

    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < rowIndex; i++) {
            result.add(f(rowIndex, i, map));
        }
        return result;
    }

    private static int f(int line, int col, Map<String, Integer> map) {
        String key = line + "_" + col;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (col == 0 || col == line - 1) {
            map.put(key, 1);
            return 1;
        }

        int res = f(line - 1, col - 1, map) + f(line - 1, col, map);
        map.put(key, res);
        return res;
    }
}
