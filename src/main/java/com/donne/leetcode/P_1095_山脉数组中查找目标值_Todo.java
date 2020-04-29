package com.donne.leetcode;

import com.donne.leetcode.model.MountainArray;
import com.donne.leetcode.model.MountainArrayImpl;

public class P_1095_山脉数组中查找目标值_Todo {
    public static void main(String[] args) {
        MountainArray mountainArray = new MountainArrayImpl(new int[]{3, 5, 3, 2, 0});
        System.out.println(getTop(mountainArray, 0, mountainArray.length() - 1));
    }


    public static int getTop(MountainArray mountainArr, int left, int right) {
        int mid1 = left + (right - left) / 3;
        int mid2 = right - (right - left) / 3;

        if (left == right) {
            return left;
        }

        if (mountainArr.get(mid1) > mountainArr.get(mid2)) {
            return getTop(mountainArr, left, mid2 - 1);
        } else {
            return getTop(mountainArr, mid1 + 1, right);
        }
    }


}
