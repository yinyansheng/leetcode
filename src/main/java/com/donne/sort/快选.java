package com.donne.sort;

public class 快选 {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 4, 1};
        quickSelect(arr, 3, 0, arr.length - 1);
        System.out.println(arr[2]);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void quickSelect(int[] nums, int k, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = nums[start];
        int l = start + 1;
        int r = end;

        while (l <= r) {
            if (nums[l] > pivot) {
                l++;
                continue;
            }

            if (nums[r] <= pivot) {
                r--;
                continue;
            }
            swap(nums, l, r);
        }

        swap(nums, start, r);

        if (r - start + 1 == k) {
            return;
        }

        if (r - start + 1 > k) {
            quickSelect(nums, k, start, r - 1);
        }

        quickSelect(nums, k - (l - start), l, end);

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
