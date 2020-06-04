package com.donne.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 */
public class P_1_两数之和 {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{3, 2, 4}, 6);
        //System.out.println(JSON.toJSONString(ints));
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        if (null == nums || 0 == nums.length) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            if (map.containsKey(left) && map.get(left) != i) {
                return new int[]{i, map.get(left)};
            }
        }

        return null;
    }


}
