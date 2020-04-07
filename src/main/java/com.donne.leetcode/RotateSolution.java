package com.donne.leetcode;

public class RotateSolution {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        print(matrix);
        rotate(matrix);

        System.out.println("=======");
        print(matrix);
    }

    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    /**
     * 1(00) 2(01) 3(02)
     * 4(10) 5(11) 6(12)
     * 7(20) 8(21) 9(22)
     *
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        //先对角线翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                //swap
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }

        //再左右翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                //swap
                int tmp = matrix[i][matrix[i].length - j - 1];
                matrix[i][matrix[i].length - j - 1] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }
}
