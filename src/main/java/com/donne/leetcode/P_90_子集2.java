package com.donne.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: yinyansheng
 * @Date: 2020-07-02
 */
public class P_90_子集2 {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int[] nums = new int[]{1, 2, 2};
        Arrays.sort(nums);

        dfs(0, nums, result, temp);
        System.out.println(result);
    }

    public static void dfs(int start, int[] nums, List<List<Integer>> result, List<Integer> tmp) {
        result.add(new ArrayList<>(tmp));

        for (int i = start; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            tmp.add(nums[i]);
            dfs(i + 1, nums, result, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
