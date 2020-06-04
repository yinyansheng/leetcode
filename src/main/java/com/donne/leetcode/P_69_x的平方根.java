package com.donne.leetcode;

public class P_69_x的平方根 {
    public static void main(String[] args) {
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(17));

    }

    public static int mySqrt(int x) {
        long low=0;
        long high = x / 2;

        while (low<=high){
            long mid = low + (high - low) / 2;
            long s1=mid*mid;
            long s2=(mid+1)*(mid+1);

            if(s1==x || (s1<x && s2>x)){
                return (int)mid;
            }else if(s1<x) {
                low = mid +1;
            }else{
                high=mid-1;
            }
        }

        return x;
    }
}
