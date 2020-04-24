package com.donne.leetcode;

public class P_58_最后一个单词的长度 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord(" "));
    }

    public static int lengthOfLastWord(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        }

        char[] chars = s.toCharArray();

        //trim 后面的空格
        int size = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                size++;
            } else {
                break;
            }
        }

        int start = 0;
        for (int i = 0; i < chars.length - size; i++) {
            if (chars[i] == ' ') {
                start = i + 1;
            }
        }

        return chars.length - size - start;
    }
}
