package com.donne.leetcode;

import java.util.Arrays;


public class P_1029_两地调度 {

    public static void main(String[] args) {
        int[][] costs = new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        System.out.println(twoCitySchedCost(costs));
    }

    public static int twoCitySchedCost(int[][] costs) {
        int[] diff = new int[costs.length];
        int sum = 0;
        //累计计算去B地-去A地的差值，同时累计计算全部去A地的费用
        for (int i = 0; i < costs.length; i++) {
            diff[i] = costs[i][1] - costs[i][0];
            sum += costs[i][0];
        }

        //从小到大排列
        Arrays.sort(diff);

        //加上本应去B地的差值
        for (int i = 0; i < diff.length / 2; i++) {
            sum += diff[i];
        }

        return sum;
    }
}
