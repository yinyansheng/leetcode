package com.donne.leetcode;

import java.util.Arrays;

/**
 * @Author: yinyansheng
 * @Date: 2020-07-13
 */
public class P_16_最接近的三数之和 {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        //最终差异
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                int diff = sum - target;
                ans = Math.abs(ans) < Math.abs(diff) ? ans : diff;

                if (diff == 0) {
                    return sum;
                }

                if (diff > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        return target + ans;
    }
}
