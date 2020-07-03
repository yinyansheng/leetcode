package com.donne.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yinyansheng
 * @Date: 2020-07-02
 */
public class P_78_子集 {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(0, new int[]{1, 2, 3}, result, temp);
        System.out.println(result);
    }

    public static void dfs(int start, int[] nums, List<List<Integer>> result, List<Integer> tmp) {
        result.add(new ArrayList<>(tmp));

        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            dfs(i + 1, nums, result, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
