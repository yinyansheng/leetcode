package com.donne.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-23
 */
public class P_22_括号生成 {

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        dfs(3, 3, result, "");
        System.out.println(result);
    }

    public static void dfs(int left, int right, List<String> result, String sb) {
        if (left == 0 && right == 0) {
            result.add(sb);
            return;
        }

        if (left > 0) {
            dfs(left - 1, right, result, sb + "(");
        }

        if (right > left) {
            dfs(left, right - 1, result, sb + ")");
        }
    }

}
