package com.donne.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P_39_组合总和 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 5};
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 8, 0, new ArrayList<>(), result);
    }

    public static void dfs(int[] candidates, int target, int start, List<Integer> list, List<List<Integer>> result) {
        Integer sum = list.isEmpty() ? 0 : list.stream().reduce(Integer::sum).get();
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(candidates, target, i, list, result);
            list.remove(list.size() - 1);
        }
    }
}
