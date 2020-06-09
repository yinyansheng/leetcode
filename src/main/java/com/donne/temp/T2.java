package com.donne.temp;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-05
 */
public class T2 {

    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 3, 5};
        quickSelect(nums, 0, nums.length - 1, 1);
        System.out.println(nums[1]);

        int[] nums2 = {2, 1, 4, 3, 5};
        mergeSort(nums2, 0, nums2.length - 1);
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = nums[start];
        int i = start + 1;
        int j = end;

        while (i < j) {
            if (nums[i] < pivot) {
                j--;
                continue;
            }

            if (nums[j] > pivot) {
                i++;
                continue;
            }
            swap(nums, i, j);
            i++;
            j--;
        }

        swap(nums, start, i);
        quickSort(nums, start, i - 1);
        quickSort(nums, i + 1, end);
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
        int[] ans = new int[end - start + 1];

        int right = start;
        int left = mid + 1;

        for (int i = 0; i < ans.length; i++) {
            if (right > mid || nums[right] > nums[left]) {
                ans[i] = nums[left];
                left++;
            } else {
                ans[i] = nums[right];
                right++;
            }
        }

        int index = 0;
        for (int i = start; i <= end - start; i++) {
            nums[i] = ans[index++];
        }
    }

    private static void quickSelect(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return;
        }

        int pivot = nums[start];
        int left = start + 1;
        int right = end;

        while (left < right) {
            if (nums[left] < pivot) {
                right--;
                continue;
            }

            if (nums[right] > pivot) {
                left++;
                continue;
            }

            swap(nums, left, right);
            left++;
            right--;
        }

        swap(nums, start, left);

        if (left == k) {
            return;
        }

        //后半部分的第k-left 个
        if (left < k) {
            quickSelect(nums, left + 1, end, k - left);
        }

        //前半部分 left-k个
        quickSelect(nums, start, left - 1, k - left);
    }


}
