package com.donne.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P_13_罗马数字转整数 {
    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }


    private static Map<Character, Integer> map = new HashMap<>();


    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    /**
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * <p>
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     *
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; ) {
            if (i != chars.length - 1 && map.get(chars[i + 1]) > map.get(chars[i])) {
                sum += map.get(chars[i + 1]) - map.get(chars[i]);
                i = i + 2;
                continue;
            }

            sum += map.get(chars[i]);
            i++;
        }

        return sum;

    }
}
