package com.donne.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class P_189_旋转数组 {

    public static void main(String[] args) {
        int[] digits = new int[]{1, 2, 3, 4, 5, 6};
        rotate(digits, 3);//6 5 4 1 2 3
        Arrays.stream(digits).forEach(System.out::println);
    }

    /**
     * 原始数组                  : 1 2 3 4 5 6 7
     * 反转所有数字后             : 7 6 5 4 3 2 1
     * 反转前 k 个数字后          : 5 6 7 4 3 2 1
     * 反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        //反转全部数组
        reverse(nums, 0, nums.length - 1);
        //反转前k个
        reverse(nums, 0, k - 1);
        //反转后n-k个
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;

            start++;
            end--;
        }
    }
}
