package com.donne.dp;

public class 背包 {

    public static void main(String[] args) {
        int[] v = new int[]{1000, 2000, 3500};
        int[] w = new int[]{1, 2, 4};

        //System.out.println(pack(v, w, 2, 3));
        pack2(v, w);
    }

    private static int pack(int[] v, int[] w, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (w[i] > j) {
            return pack(v, w, i - 1, j);
        }

        int v1 = pack(v, w, i - 1, j);
        int v2 = pack(v, w, i - 1, j - w[i]) + v[i];
        return Math.max(v1, v2);
    }


    private static int pack2(int[] v, int[] w) {
        int[][] dpTable = new int[v.length + 1][v.length + 1];

        //初始化第一列为0
        for (int i = 0; i < dpTable.length; i++) {
            dpTable[i][0] = 0;
        }
        //初始化第一行为0
        for (int j = 0; j < dpTable[0].length; j++) {
            dpTable[0][j] = 0;
        }

        //todo dpTable


        for (int i = 0; i < dpTable.length; i++) {
            for (int j = 0; j < dpTable[0].length; j++) {
                System.out.print(dpTable[i][j] + "\t");
            }
            System.out.println();
        }

        return 0;
    }

}
