package com.donne.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P_56_合并区间 {

    public static void main(String[] args) {
        int a = 100;
        int b = 0;
        System.out.println(b = a);

    }


    public static int[][] merge(int[][] intervals) {
        //1.按开始时间排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int[] previous = null;
        List<int[]> result = new ArrayList<>();

        for (int[] current : intervals) {
            if (previous == null || current[0] > previous[1]) {
                //未发生融合，将previous放入结果集，将当前区间变为previous
                result.add(previous = current);
            } else {
                //发生融合，修改previous的尾值
                previous[1] = Math.max(previous[1], current[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
