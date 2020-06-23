package com.donne.leetcode;

public class P_215_数组中的第K个最大元素 {

    public static void main(String[] args) {
        int[] nums = {5, 2, 4, 1, 3, 6, 0};
        quickSelect(nums, 0, nums.length - 1, 3);
        System.out.println(nums[3]);
    }

    public static void quickSelect(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return;
        }

        int pivot = nums[start];
        int left = start + 1;
        int right = end;

        while (left <= right) {
            if (nums[left] > pivot) {
                left++;
                continue;
            }

            if (nums[right] <= pivot) {
                right--;
                continue;
            }

            swap(nums, left, right);
        }

        swap(nums, start, right);
//        quickSelect(nums, start, right - 1, 0);
//        quickSelect(nums, left, end, 0);

        if (k == right) {
            return;
        }

        if (k > right) {
            quickSelect(nums, k - (left - start), end, k - left);
        }

        quickSelect(nums, start, right - 1, k);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
