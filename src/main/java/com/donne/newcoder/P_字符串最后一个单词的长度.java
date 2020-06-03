package com.donne.newcoder;

import java.util.Scanner;

public class P_字符串最后一个单词的长度 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(input.length() - 1 - input.trim().lastIndexOf(' '));
    }
}
