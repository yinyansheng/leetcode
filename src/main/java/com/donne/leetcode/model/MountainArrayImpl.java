package com.donne.leetcode.model;

public class MountainArrayImpl implements MountainArray {

    private int[] nums;

    public MountainArrayImpl(int[] nums) {
        this.nums = nums;
    }


    @Override
    public int get(int index) {
        return nums[index];
    }

    @Override
    public int length() {
        return nums.length;
    }
}
