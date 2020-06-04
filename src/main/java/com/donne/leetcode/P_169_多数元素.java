package com.donne.leetcode;

public class P_169_多数元素 {
    public static void main(String[] args) {
        int[] nums = {4, 5, 4};
        //quickSort(nums, 0, nums.length - 1);
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != candidate) {
                count--;
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            } else {
                count++;
            }
        }
        return candidate;
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start > end) {
            return;
        }

        int pivot = nums[start];
        int left = start + 1;
        int right = end;

        while (left <= right) {
            if (nums[left] < pivot) {
                left++;
                continue;
            }
            if (nums[right] >= pivot) {
                right--;
                continue;
            }

            swap(nums, left, right);
        }

        swap(nums, start, right);
        quickSort(nums, start, right - 1);
        quickSort(nums, left, end);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
