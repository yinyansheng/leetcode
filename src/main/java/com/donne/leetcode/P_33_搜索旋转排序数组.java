package com.donne.leetcode;

public class P_33_搜索旋转排序数组 {
    public static void main(String[] args) {
        int[] nums=new int[]{4,5,6,7,8,1,2,3};
        System.out.println(search(nums,8));
    }


    public static int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;

        while (left<=right){
            int mid=(left+right)/2;

            if(nums[mid]==target){
                return mid;
            }

            if(nums[mid]>=nums[left]){
                if(target>=nums[left]  && target<nums[mid]){
                    right=mid-1;
                }else {
                    left=mid+1;
                }
            }else {//如果中间数小于目标值
                if(target<=nums[right] && target>nums[mid]){
                    left=mid+1;
                }else {
                    right =mid-1;
                }
            }
        }

        return -1;
    }

    private static int binSearch(int[] nums,int left,int right,int target){
        while (left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }else if (nums[mid]<target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return -1;
    }

}
