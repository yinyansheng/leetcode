package com.donne.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yinyansheng
 * @Date: 2020-07-02
 */
public class P_47_全排列II {


    public void permuteUnique(int start, int[] nums, List<List<Integer>> result, List<Integer> temp) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            temp.add(nums[i]);
            permuteUnique(i + 1, nums, result, temp);
            temp.remove(temp.size() - 1);
        }
    }

}
