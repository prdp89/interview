package com.interview.companies.amazon;

import java.util.Arrays;

public class SpiralMatrixII {

    //https://leetcode.com/problems/spiral-matrix-ii/
    public static void main( String[] args ) {

        int[][] res = generateMatrix(4);

        for (int[] arr : res) {
            System.out.println(Arrays.toString(arr));
        }
    }

    //ref: lovesly code
    private static int[][] generateMatrix( int n ) {

        int[][] res = new int[n][n];

        int cur = 1;
        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;

        while (cur <= n * n) {

            int i = rowBegin;
            int j = colBegin;

            //left to right
            for (j = colBegin; j <= colEnd; j++) {
                res[rowBegin][j] = cur++;
            }
            rowBegin++;

            //top to bot .. from end column to Bottom column
            for (i = rowBegin; i <= rowEnd; i++) {
                res[i][colEnd] = cur++;
            }
            colEnd--;

            //right to left..from end column on last row to first column of last row..
            for (j = colEnd; j >= colBegin; j--) {
                res[rowEnd][j] = cur++;
            }
            rowEnd--;

            //bot to top..from last row first column to first row of first column..
            for (i = rowEnd; i >= rowBegin; i--) {
                res[i][colBegin] = cur++;
            }
            colBegin++;
        }

        return res;
    }
}
