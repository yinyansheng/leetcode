package com.donne.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-10
 */
public class P_12_整数转罗马数字 {
    private static Map<Integer, String> map = new TreeMap<>((o1, o2) -> o2 - o1);

    static {
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            int times = num / key;
            for (int i = 0; i < times; i++) {
                sb.append(value);
            }
            num %= key;
        }
        return sb.toString();
    }
}
