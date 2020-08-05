package com.donne.temp;

import java.util.Arrays;

public class MergeSortSolution {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 3, 1, 7, 2};
        mergeSort(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(r -> System.out.println(r));
    }

    private static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int[] sort = new int[right - left + 1];
        int i = left;
        int j = mid + 1;

        int idx = 0;
        while (i <= mid || j <= right) {
            if (i > mid) {
                sort[idx++] = nums[j++];
                continue;
            }

            if (j > right) {
                sort[idx++] = nums[i++];
                continue;
            }

            if (nums[i] < nums[j]) {
                sort[idx++] = nums[i++];
            } else {
                sort[idx++] = nums[j++];
            }
        }

        for (int k = left; k <= right; k++) {
            nums[k] = sort[k - left];
        }
    }
}
