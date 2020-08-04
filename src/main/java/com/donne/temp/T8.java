package com.donne.temp;

import java.util.Arrays;

public class T8 {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 1, 2, 4};
        mergeSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(r -> System.out.println(r));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = arr[start];
        int left = start + 1;
        int right = end;

        while (left <= right) {
            if (arr[left] <= pivot) {
                left++;
                continue;
            }

            if (arr[right] > pivot) {
                right--;
                continue;
            }

            swap(arr, left, right);
        }

        swap(arr, start, right);
        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, left);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    private static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
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
