package com.donne.newcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P_百钱买百鸡问题 {

    /**
     * 公鸡 5
     * 母鸡 3
     * 小鸡 1/3
     * <p>
     * 5a+3b+1/3*c=100
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        List<List<Integer>> result = new ArrayList<>();
        for (int a = 0; a <= 20; a++) {
            for (int b = 0; b <= 33; b++) {
                if (a * 5 + b * 3 > 100) {
                    break;
                }

                for (int c = 0; c <= 300; c += 3) {
                    int sum = a * 5 + b * 3 + c / 3;
                    if (sum > 100) {
                        break;
                    }

                    if (sum == 100) {
                        result.add(Arrays.asList(a, b, c));
                    }
                }
            }
        }

        result.forEach(list -> {
            list.forEach(r -> System.out.print(r + " "));
            System.out.println();
        });
    }
}
