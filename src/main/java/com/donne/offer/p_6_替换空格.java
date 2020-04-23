package com.donne.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: yinyansheng
 * @Date: 2020-04-23
 */
public class p_6_替换空格 {
    /**
     * replace 函数
     * regex 函数
     * 指针
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = " abc de fa a   a ";
        List<Character> charList = new ArrayList<>();
        List<String> stringsList = new ArrayList<>();

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                if (charList.isEmpty()) {
                    continue;
                }

                StringBuilder sb = new StringBuilder();
                charList.forEach(sb::append);
                stringsList.add(sb.toString());
                charList.clear();
            } else {
                charList.add(chars[i]);
            }
        }

        System.out.println(stringsList.stream().collect(Collectors.joining("%20")));
    }
}
