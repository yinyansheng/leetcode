package com.donne.temp;

public class QuickSelectSolution {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 3, 1, 7, 2};
        quickSelect(nums, 0, nums.length - 1, 1);
        System.out.println(nums[1]);
    }

    private static void quickSelect(int[] nums, int left, int right, int k) {
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

        if (j == k) {
            return;
        }

        if (j > k) {
            quickSelect(nums, left, j - 1, k);
        } else {
            quickSelect(nums, j + 1, right, k - j);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
