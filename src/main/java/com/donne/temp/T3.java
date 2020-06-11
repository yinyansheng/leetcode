package com.donne.temp;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-10
 */
public class T3 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 1, 4, 2};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(binarySearch(nums, 0, nums.length - 1, 31));
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
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

            if (nums[right] > pivot) {
                right--;
                continue;
            }

            swap(nums, left, right);
        }

        swap(nums, start, right);
        quickSort(nums, start, right - 1);
        quickSort(nums, left, end);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        if (nums[mid] > target) {
            return binarySearch(nums, left, mid - 1, target);
        }

        return binarySearch(nums, mid + 1, right, target);
    }

    
}
