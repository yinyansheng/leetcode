package com.donne.sort;

public class 归排 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 13, 12};
        mergeSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
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
        int[] sort = new int[end - start + 1];

        int i = start;
        int j = mid + 1;
        for (int idx = 0; idx <= end - start; idx++) {
            if (i > mid) {
                sort[idx] = nums[j];
                j++;
                continue;
            }

            if (j > end) {
                sort[idx] = nums[i];
                i++;
                continue;
            }

            if (nums[i] < nums[j]) {
                sort[idx] = nums[i];
                i++;
            } else {
                sort[idx] = nums[j];
                j++;
            }
        }

        for (int idx = 0; idx <= end - start; idx++) {
            nums[idx + start] = sort[idx];
        }
    }
}
