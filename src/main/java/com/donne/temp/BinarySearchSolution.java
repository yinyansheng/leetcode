package com.donne.temp;

import java.util.Arrays;

public class BinarySearchSolution {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 3, 1, 7, 2};
        Arrays.sort(nums);

        System.out.println(binarySearch(nums, 0, nums.length - 1, 4));
    }

    private static int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return nums[right];
        }

        int mid = left + (right - left) / 2;
        
        if (nums[mid] == target) {
            return nums[mid];
        }

        if (nums[mid] > target) {
            return binarySearch(nums, left, mid - 1, target);
        }

        return binarySearch(nums, mid + 1, right, target);
    }

}
