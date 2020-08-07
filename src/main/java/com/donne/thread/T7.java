package com.donne.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T7 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(1, 2, 3));
        lists.add(Arrays.asList(4, 5));

        List<String> result = new ArrayList<>();

        dfs(lists, result, "");
        System.out.println(result);
    }

    private static void dfs(List<List<Integer>> lists, List<String> result, String temp) {
        //返回条件
        if (temp.length() == lists.size()) {
            result.add(temp);
            return;
        }

        //当前需要选择的数组
        List<Integer> list = lists.get(temp.length());

        for (int j = 0; j < list.size(); j++) {
            dfs(lists, result, temp + list.get(j));
        }
    }
}
