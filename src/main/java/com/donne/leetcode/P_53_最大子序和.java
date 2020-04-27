package com.donne.leetcode;

public class P_53_最大子序和 {
    public static void main(String[] args) {
        int[] nums=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        //System.out.println(maxSubArray(nums));


    }

    public static int maxSubArray(int[] nums) {
        if(nums==null){
            return 0;
        }

        //迄今为止最大和
        int max=nums[0];
        //当前元素为止 迄今最大和
        int sum=nums[0];

        for(int i=1;i<nums.length;i++){
           sum=Math.max(sum+nums[i],nums[i]);
           max=Math.max(max,sum);
        }
        return max;

    }

    public static int maxSubArray2(int[] nums) {
        if(nums==null){
            return 0;
        }

        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            max=Math.max(dp(nums,i),nums[i]);
        }
        return max;
    }

    public static int dp(int[] nums,int i) {
        if(nums==null){
            return 0;
        }

        if(i==0){
            return nums[i];
        }

        //dp[i]=max(dp[i-1]+nums[i],nums[i])
        return Math.max(dp(nums,i-1)+nums[i],nums[i]);
    }
}
