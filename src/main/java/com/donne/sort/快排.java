package com.donne.sort;

public class 快排 {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 4, 1};
        quickSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = nums[start];
        int l = start + 1;
        int r = end;
        while (l <= r) {
            if (nums[l] < pivot) {
                l++;
                continue;
            }

            if (nums[r] >= pivot) {
                r--;
                continue;
            }

            swap(nums, l, r);
        }

        swap(nums, start, r);
        quickSort(nums, start, r - 1);
        quickSort(nums, l, end);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
