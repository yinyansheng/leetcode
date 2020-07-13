package com.donne.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yinyansheng
 * @Date: 2020-07-13
 */
public class P_350_两个数组的交集II {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int value : nums1) {
            if (!map.containsKey(value)) {
                map.put(value, 1);
            } else {
                map.put(value, map.get(value) + 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int value : nums2) {
            if (map.containsKey(value) && map.get(value) > 0) {
                list.add(value);
                map.put(value, map.get(value) - 1);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
