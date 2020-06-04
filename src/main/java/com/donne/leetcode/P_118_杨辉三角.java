package com.donne.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P_118_杨辉三角 {
    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);
        generate.forEach(r -> {
            r.forEach(x -> {
                System.out.print(x);
            });
            System.out.println("");
        });
    }


    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    list.add(1);
                    continue;
                }

                //上一个数组的a[j-1] + [j]
                List<Integer> lastList = lists.get(lists.size() - 1);
                list.add(lastList.get(j - 1) + lastList.get(j));
            }
            lists.add(list);
        }
        return lists;
    }
}
