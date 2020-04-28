package com.donne.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_56_数组中数字出现的次数 {
    public static void main(String[] args) {

    }

    public static int[] singleNumbers(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.remove(nums[i]);
            }else {
                map.put(nums[i],1);
            }
        }

        int[] res=new int[map.size()];
        int i=0;
        for (Integer r : map.keySet()) {
            res[i++]=r;
        }
        return res;
    }
}
