package com.donne.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: yinyansheng
 * @Date: 2020-07-15
 */
public class P_面试题17_14_最小K个数 {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 13, 15, 7, 2, 4, 6, 18};
        //quickSort(arr, 4, 0, arr.length - 1);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        Arrays.stream(arr).forEach(r -> {
            if (priorityQueue.size() < 4) {
                priorityQueue.add(r);
            }

            if (priorityQueue.peek() < r) {
                priorityQueue.poll();
                priorityQueue.add(r);
            }
        });

        priorityQueue.forEach(System.out::println);
    }

    private static void quickSort(int[] arr, int k, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = arr[start];
        int left = start + 1;
        int right = end;

        while (left <= right) {
            if (arr[left] < pivot) {
                left++;
                continue;
            }

            if (arr[right] >= pivot) {
                right--;
                continue;
            }

            swap(arr, left, right);
        }
        swap(arr, start, right);

        if (right + 1 - start == k) {
            return;
        }

        if (right + 1 - start > k) {
            quickSort(arr, k, start, right - 1);
            return;
        }

        quickSort(arr, k - (right - start + 1), left, end);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
