package com.donne.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_46_全排列 {
    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3, 4}, 0);
        permute.forEach(r -> {
            r.forEach(r1 -> System.out.print(r1));
            System.out.println("|");
        });

    }

    public static List<List<Integer>> permute(int[] nums, int start) {
        if (start == nums.length - 1) {
            return Collections.singletonList(Collections.singletonList(nums[start]));
        }

        List<List<Integer>> lists = new ArrayList<>();
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            List<List<Integer>> permute = permute(nums, start + 1);
            permute.forEach(r -> {
                List<Integer> list = new ArrayList<>();
                list.add(nums[start]);
                list.addAll(r);
                lists.add(list);
            });
            swap(nums, start, i);
        }

        return lists;
    }

    private static void swap(int[] nums, int a, int b) {
        //交换
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
