package com.donne.leetcode;

public class P_26_删除排序数组中的重复项 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }

        int curr = 0;
        int preValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != preValue) {
                curr++;
                nums[curr] = nums[i];
                preValue = nums[i];
            }
        }

        return curr + 1;

    }
}
