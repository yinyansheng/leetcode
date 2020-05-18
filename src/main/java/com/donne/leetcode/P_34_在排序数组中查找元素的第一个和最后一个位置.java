package com.donne.leetcode;

public class P_34_在排序数组中查找元素的第一个和最后一个位置 {

    public static void main(String[] args) {

    }

    /**
     * 下边界条件
     * nums[i]==target
     * i==0 || nums[i-1]<target
     *
     * @param nums
     * @param target
     * @param low
     * @param high
     * @return
     */
    private int getLower(int[] nums, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        if (nums[mid] == target && (mid == 0 || nums[mid - 1] < nums[mid])) {
            return mid;
        }

        if (nums[mid] >= target) {
            return getLower(nums, target, low, mid - 1);
        }

        return getLower(nums, target, mid + 1, high);
    }

    private int getHigher(int[] nums, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        if (nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] > nums[mid])) {
            return mid;
        }

        if (nums[mid] > target) {
            return getHigher(nums, target, low, mid - 1);
        }

        return getHigher(nums, target, mid + 1, high);
    }
}
