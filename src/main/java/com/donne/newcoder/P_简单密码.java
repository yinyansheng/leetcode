package com.donne.newcoder;

import java.util.Scanner;

public class P_简单密码 {
    public static void main(String[] args) {
        String plainText = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String cipherText = "bcdefghijklmnopqrstuvwxyza22233344455566677778889999";
        char[] cipherChars = cipherText.toCharArray();
        Scanner scanner = new Scanner(System.in);
        String pwd = scanner.nextLine();

        char[] chars = pwd.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                continue;
            }
            chars[i] = cipherChars[plainText.indexOf(chars[i])];
        }

        System.out.println(new String(chars));
    }
}
