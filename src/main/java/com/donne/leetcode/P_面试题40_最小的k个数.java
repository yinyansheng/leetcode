package com.donne.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P_面试题40_最小的k个数 {
    public static void main(String[] args) {
        //Arrays.stream(getLeastNumbers(new int[]{0, 0, 1, 2, 4, 2, 2, 3, 1, 4}, 8)).forEach(System.out::println);

        int[] arr = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        quickSelect(arr, 4, 0, arr.length - 1);

        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(arr[i]);
        }
    }

    public static void quickSelect(int[] arr, int k, int start, int end) {
        if (start > end) {
            return;
        }

        int pivot = arr[start];
        int left = start + 1;
        int right = end;

        while (left <= right) {
            if (arr[left] > pivot) {
                swap(arr, left, right);
                right--;
                continue;
            }

            if (arr[right] <= pivot) {
                swap(arr, left, right);
                left++;
                continue;
            }

            left++;
            right--;
        }

        swap(arr, start, right);

        if (k == right - start + 1) {
            return;
        }

        if (k < right - start + 1) {
            quickSelect(arr, k, start, right - 1);
        }

        quickSelect(arr, k - (left - start), left, end);
    }


    public static void quickSort(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }

        int pivot = arr[start];
        int left = start + 1;
        int right = end;

        while (left <= right) {
            if (arr[left] > pivot) {
                swap(arr, left, right);
                right--;
                continue;
            }

            if (arr[right] <= pivot) {
                swap(arr, left, right);
                left++;
                continue;
            }

            left++;
            right--;
        }

        swap(arr, start, right);
        quickSort(arr, start, right - 1);
        quickSort(arr, left, end);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 小顶堆
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        //构造大顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, (i1, i2) -> i2 - i1);

        for (int i1 : arr) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(i1);
            } else if (i1 < priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(i1);
            }
        }


        int[] res = new int[k];

        int i = 0;
        for (Integer r : priorityQueue) {
            res[i] = r;
            i++;
        }
        return res;
    }
}
