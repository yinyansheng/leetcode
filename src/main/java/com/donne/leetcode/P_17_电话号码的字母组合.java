package com.donne.leetcode;

import java.util.*;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-15
 */
public class P_17_电话号码的字母组合 {
    public static void main(String[] args) {
        dfs("", 0, new StringBuilder(""));

    }


    private static Map<Character, List<Character>> keyContext = new HashMap<>();

    static {
        keyContext.put('2', Arrays.asList('a', 'b', 'c'));
        keyContext.put('3', Arrays.asList('d', 'e', 'f'));
        keyContext.put('4', Arrays.asList('g', 'h', 'i'));
        keyContext.put('5', Arrays.asList('j', 'k', 'l'));
        keyContext.put('6', Arrays.asList('m', 'n', 'o'));
        keyContext.put('7', Arrays.asList('p', 'q', 'r', 's'));
        keyContext.put('8', Arrays.asList('t', 'u', 'v'));
        keyContext.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    private static List<String> ansList = new ArrayList<>();

    private static void dfs(String digits, int depth, StringBuilder sb) {
        //终止条件
        if (depth == digits.length()) {
            ansList.add(sb.toString());
            return;
        }

        List<Character> list = keyContext.get(digits.charAt(depth));
        for (int i = 0; i < list.size(); i++) {
            //做出选择
            Character c = list.get(i);
            dfs(digits, depth + 1, sb.append(c));
            //撤销选择
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
