package com.donne.leetcode;

import java.util.*;

public class P_498_对角线遍历 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        int[] diagonalOrder = findDiagonalOrder(grid);
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (map.containsKey(i + j)) {
                    map.get(i + j).add(matrix[i][j]);
                } else {
                    map.put(i + j, new ArrayList<>(Arrays.asList(matrix[i][j])));
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        Iterator<Map.Entry<Integer, List<Integer>>> iterator = map.entrySet().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Map.Entry<Integer, List<Integer>> next = iterator.next();
            if (i % 2 == 1) {
                ans.addAll(next.getValue());
            } else {
                Collections.reverse(next.getValue());
                ans.addAll(next.getValue());
            }
            i++;
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

}
