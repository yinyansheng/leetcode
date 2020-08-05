package com.donne.temp;

import java.util.Arrays;

public class QuickSortSolution {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 3, 1, 7, 2};
        quickSort(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(System.out::println);
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = left;
        int i = left + 1;
        int j = right;

        while (i <= j) {
            if (nums[i] < nums[pivot]) {
                i++;
                continue;
            }

            if (nums[j] >= nums[pivot]) {
                j--;
                continue;
            }

            swap(nums, i, j);
        }

        swap(nums, pivot, j);
        quickSort(nums, left, j - 1);
        quickSort(nums, j + 1, right);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
