package com.donne.leetcode;

public interface P_240_搜索二维矩阵II {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(searchMatrix(matrix, 8));
    }

    /**
     * O(m+n)
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int x = 0;
        int y = matrix[x].length - 1;

        while (y >= 0 && x <= matrix.length - 1) {
            if (matrix[x][y] == target) {
                return true;
            }

            if (matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}
