package com.donne.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P_1481_不同整数的最少数目 {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 5, 4};
        System.out.println(findLeastNumOfUniqueInts(nums, 1));


    }

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : arr) {
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else {
                map.put(value, 1);
            }
        }

        List<Integer> count = map.values().stream().sorted().collect(Collectors.toList());

        int size = count.size();
        for (int i = 0; i < count.size(); i++) {
            if (k >= count.get(i)) {
                size--;
                k -= count.get(i);
                continue;
            }
            break;
        }

        return size;
    }
}
