package com.donne.dp;

public class Knapsack {

    public static void main(String[] args) {
        int[] weights = new int[]{2, 3, 4, 5, 9};
        int[] values = new int[]{3, 4, 5, 8, 10};

        System.out.println(dp(weights, values, 10, values.length - 1));
    }

    public static int dp(int[] weights, int[] values, int capacity, int i) {
        if (i < 0) {
            return 0;
        }

        if (weights[i] > capacity) {
            return dp(weights, values, capacity, i - 1);
        }

        return Math.max(
                dp(weights, values, capacity, i - 1),
                dp(weights, values, capacity - weights[i], i - 1) + values[i]
        );
    }
}
