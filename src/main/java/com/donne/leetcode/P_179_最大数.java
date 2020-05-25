package com.donne.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class P_179_最大数 {

    public static void main(String[] args) {
        int[] nums = new int[]{10, 2};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        if(Arrays.stream(nums).allMatch(r->r==0)){
            return "0";
        }
        Comparator<String> comparator = (o1, o2) -> (o1 + o2).compareTo(o2 + o1);
        return Arrays.stream(nums).mapToObj(String::valueOf).sorted(comparator.reversed()).collect(Collectors.joining(""));
    }


}
