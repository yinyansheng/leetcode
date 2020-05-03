package com.donne.leetcode;

public class P_912_排序数组 {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 4, 1};
        mergeSort(arr, 0, arr.length - 1);

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
        quickSort(nums, r + 1, end);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    private static void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;

        int[] temp = new int[end - start + 1];
        for (int k = 0; k < temp.length; k++) {
            if (i > mid) {
                temp[k] = nums[j];
                j++;
                continue;
            }

            if (j > end) {
                temp[k] = nums[i];
                i++;
                continue;
            }

            if (nums[i] < nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }
        }

        for (int idx = 0; idx < temp.length; idx++) {
            nums[idx + start] = temp[idx];
        }
    }

}
