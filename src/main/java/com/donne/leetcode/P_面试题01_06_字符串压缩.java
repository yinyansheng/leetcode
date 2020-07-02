package com.donne.leetcode;

/**
 * @Author: yinyansheng
 * @Date: 2020-07-02
 */
public class P_面试题01_06_字符串压缩 {
    public static void main(String[] args) {
        System.out.println(compressString("aaaaaaaaaaaa"));
    }

    public static String compressString(String S) {
        char curr = S.charAt(0);
        int count = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(curr);

        for (char c : S.toCharArray()) {
            if (c == curr) {
                count++;
            } else {
                sb.append(count);
                sb.append(c);
                curr = c;
                count = 1;
            }
        }
        sb.append(count);

        return sb.length() <= S.length() ? sb.toString() : S;
    }


}
