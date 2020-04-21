package com.donne.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix/solution/
 */
public class P_螺旋数据 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(matrix));
    }

    /**
     * 按层遍历
     * 1    2   3
     * 4    5   6
     * <p>
     * 3(0,0)
     * 2(1,0)
     * <p>
     * 1    2
     * 3    4
     *
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return Collections.emptyList();
        }

        int ax = 0;
        int ay = 0;
        int bx = matrix.length - 1;
        int by = matrix[0].length - 1;

        List<Integer> res = new ArrayList<>();

        while (ax <= bx && ay <= by) {

            for (int i = ax; i <= by; i++) {
                res.add(matrix[ax][i]);
                if (i == by) {
                    for (int j = ax + 1; j <= bx; j++) {
                        res.add(matrix[j][by]);
                        if (j == bx) {
                            for (int k = by - 1; k >= ay; k--) {
                                res.add(matrix[bx][k]);
                                if (k == ay) {
                                    for (int m = bx - 1; m >= ax + 1; m--) {
                                        res.add(matrix[m][ay]);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            ax++;
            ay++;
            bx--;
            by--;
        }


        return res;

    }

}
