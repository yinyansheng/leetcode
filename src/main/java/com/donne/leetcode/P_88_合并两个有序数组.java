package com.donne.leetcode;

import java.util.Arrays;

public class P_88_合并两个有序数组 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 0, 0, 0, 0, 0};
        int[] nums2 = new int[]{1, 2, 3, 5, 6};

        merge(nums1, 1, nums2, 5);
        Arrays.stream(nums1).forEach(r -> System.out.println(r));

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        //双指针归并排序
        int ptr1 = 0;
        int ptr2 = 0;
        int[] res = new int[nums1.length];

        int i = 0;
        while (ptr1 < m || ptr2 < n) {
            if (ptr1 == m) {
                res[i++] = nums2[ptr2];
                ptr2++;
                continue;
            }

            if (ptr2 == n) {
                res[i++] = nums1[ptr1];
                ptr1++;
                continue;
            }

            if (nums1[ptr1] < nums2[ptr2]) {
                res[i++] = nums1[ptr1];
                ptr1++;
            } else {
                res[i++] = nums2[ptr2];
                ptr2++;
            }
        }

        for (int j = 0; j < res.length; j++) {
            nums1[j] = res[j];
        }
    }
}
