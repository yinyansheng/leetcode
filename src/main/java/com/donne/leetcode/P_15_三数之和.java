package com.donne.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-12
 */
public class P_15_三数之和 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return lists;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];

                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                    continue;
                }

                if (sum > 0) {
                    right--;
                    continue;
                }

                left++;
            }
        }

        return lists;
    }
}
