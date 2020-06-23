package com.donne.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-22
 */
public class P_51_N皇后 {
    public static void main(String[] args) {
        int n = 8;
        List<List<String>> result = new ArrayList<>();
        int[][] grid = new int[n][n];
        dfs(result, grid, n, 0);
    }

    public static void dfs(List<List<String>> result, int[][] grid, int n, int r) {
        if (r == n) {
            List<String> list = new ArrayList<>();
            for (int[] row : grid) {
                list.add(Arrays.stream(row).mapToObj(String::valueOf).collect(Collectors.joining(",")));
            }
            result.add(list);
            return;
        }


        for (int col = 0; col < n; col++) {
            if (judge(grid, r, col)) {
                grid[r][col] = 1;
                dfs(result, grid, n, r + 1);
                grid[r][col] = 0;
            }
        }

    }

    private static boolean judge(int[][] grid, int row, int col) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> columnSet = new HashSet<>();
        Set<Integer> slashSet = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                rowSet.add(i);
                columnSet.add(j);
                slashSet.add(Math.abs(i - j));
            }
        }

        if (rowSet.contains(row) || columnSet.contains(col) || slashSet.contains(Math.abs(row - col))) {
            return false;
        }

        return true;
    }

}
