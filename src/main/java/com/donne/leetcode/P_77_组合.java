package com.donne.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_77_组合 {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        int[] nums = new int[2];
        for (int i = 0; i < 2; i++) {
            nums[i] = i + 1;
        }
        dfs(nums, 2, 0, new ArrayList<>(), result);
    }

    private static void dfs(int[] nums, int k, int start, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, k, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }
}
