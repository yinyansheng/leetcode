package com.donne.dp;

import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.Map;

public class 找零钱 {
    public static void main(String[] args) {
        int[] coins = new int[]{5, 3, 1};
        //System.out.println(dp(5, coins));
        //System.out.println(dp(10, coins));
        Map<Integer, Integer> memo = new HashMap<>();
        System.out.println(dp(4, coins, memo));
    }


    /**
     * 状态转移方程
     * n=0 return 0;
     * n<0 return -1;
     * <p>
     * dp(n)=min{dp(n-coin)+1} |coin in coins
     *
     * @param amount
     * @param coins
     * @return
     */
    private static int dp(int amount, int[] coins, Map<Integer, Integer> memo) {
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        if (amount == 0) {
            memo.put(0, 0);
            return 0;
        }

        if (amount < 0) {
            memo.put(amount, -1);
            return -1;
        }

        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int dp = dp(amount - coins[i], coins, memo);
            if (dp == -1) {
                continue;
            }
            minCount = Math.min(minCount, dp + 1);
        }
        int res = minCount == Integer.MAX_VALUE ? -1 : minCount;
        memo.put(amount, res);
        return res;
    }

}
