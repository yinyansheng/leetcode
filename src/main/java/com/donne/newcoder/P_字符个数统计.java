package com.donne.newcoder;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P_字符个数统计 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(Arrays.stream(input.split("")).collect(Collectors.toSet()).size());
    }
}
