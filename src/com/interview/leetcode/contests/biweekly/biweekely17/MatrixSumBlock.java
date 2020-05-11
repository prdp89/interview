package com.interview.leetcode.contests.biweekly.biweekely17;

import java.util.Arrays;

public class MatrixSumBlock {

    //https://leetcode.com/contest/biweekly-contest-17/problems/matrix-block-sum/
    public static void main( String[] args ) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int k = 1;

        System.out.println(Arrays.deepToString(matrixBlockSum(arr, k)));
    }

    //This program teaches PreFix sum on 2D matrix
    private static int[][] matrixBlockSum( int[][] mat, int k ) {
        int m = mat.length, n = mat[0].length;

        int[][] prefix = new int[m][n];
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {

            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += mat[i][j];
                prefix[i][j] = sum;
            }
        }

        //didn't understood well this part..
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                int r1 = Math.max(0, i - k);
                int r2 = Math.min(m - 1, i + k);

                int c1 = Math.max(0, j - k);
                int c2 = Math.min(n - 1, j + k);

                for (int t = r1; t <= r2; t++) {
                    res[i][j] += prefix[t][c2];

                    if (c1 != 0) {
                        res[i][j] -= prefix[t][c1 - 1];
                    }
                }
            }
        }

        return res;
    }
}
