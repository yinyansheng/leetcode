package com.donne.leetcode;

public class P_面试题_17_10_主要元素 {
    public int majorityElement(int[] nums) {
        int ans = nums[0];
        int times = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != ans) {
                times--;
            } else {
                times++;
            }

            if (times == 0) {
                ans = nums[i];
                times = 1;
            }
        }

        return ans;
    }
}
