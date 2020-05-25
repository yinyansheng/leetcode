package com.donne.leetcode;

import java.util.*;

public class P_1424_对角线遍历II {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        List<Integer> ans=new ArrayList();
        ans.toArray(new Integer[]{});

        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (map.containsKey(i + j)) {
                    List<Integer> integers = map.get(i + j);
                    integers.add(grid[i][j]);
                } else {
                    map.put(i + j, new ArrayList<>(Collections.singletonList(grid[i][j])));
                }
            }
        }

        int[] ans1 = new int[grid.length * grid[0].length];
        int index = 0;
        Iterator<Map.Entry<Integer, List<Integer>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, List<Integer>> next = iterator.next();
            for (int i = next.getValue().size() - 1; i >= 0; i--) {
                ans1[index++] = next.getValue().get(i);
            }
        }
    }


}
