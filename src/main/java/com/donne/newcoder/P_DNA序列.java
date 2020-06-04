package com.donne.newcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: yinyansheng
 * @Date: 2020-06-04
 */
public class P_DNA序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Integer size = scanner.nextInt();

        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 0);
        int preSum = 0;
        for (int i = 0; i < input.toCharArray().length; i++) {
            if (input.charAt(i) == 'G' || input.charAt(i) == 'C') {
                preSum++;
            }
            preSumMap.put(i + 1, preSum);
        }

        int end = size - 1;
        int sum = -1;
        for (int i = size - 1; i < input.toCharArray().length; i++) {
            int tmpSum = preSumMap.get(i + 1) - preSumMap.get(i + 1 - size);
            if (tmpSum > sum) {
                end = i;
                sum = tmpSum;
            }
        }

        System.out.println(input.substring(end - size + 1, end + 1));
    }
}
