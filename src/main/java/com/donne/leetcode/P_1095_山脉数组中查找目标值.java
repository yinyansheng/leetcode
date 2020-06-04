package com.donne.leetcode;

import com.donne.leetcode.model.MountainArray;
import com.donne.leetcode.model.MountainArrayImpl;

public class P_1095_山脉数组中查找目标值 {
    public static void main(String[] args) {
        MountainArray mountainArray = new MountainArrayImpl(new int[]{3, 5, 3, 2, 0});
        int top = getTop(mountainArray);
        int res = binarySearchUp(mountainArray, 0, top, 3);

        if (res == -1) {
            res = binarySearchDown(mountainArray, top + 1, mountainArray.length() - 1, 3);
        }

        System.out.println(res);
    }

    public static int binarySearchDown(MountainArray mountainArr, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;

            int m = mountainArr.get(mid);
            if (m == target) {
                return mid;
            } else if (m > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchUp(MountainArray mountainArr, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;

            int m = mountainArr.get(mid);
            if (m == target) {
                return mid;
            } else if (m > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


    public static int getTop(MountainArray mountainArr) {
        int low = 0;
        int high = mountainArr.length() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (mid == 0) {
                low = mid + 1;
                continue;
            }

            if (mid == mountainArr.length() - 1) {
                high = mid - 1;
                continue;
            }

            int p = mountainArr.get(mid - 1);
            int m = mountainArr.get(mid);
            int n = mountainArr.get(mid + 1);
            if (m > p && m > n) {
                return mid;
            } else if (m > p) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;

    }


}
