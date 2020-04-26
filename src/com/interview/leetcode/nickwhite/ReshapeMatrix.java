package com.interview.leetcode.nickwhite;

import java.util.Arrays;

public class ReshapeMatrix {

    //https://leetcode.com/problems/reshape-the-matrix/
    public static void main( String[] args ) {
        int[][] nums = {
                {1, 2},
                {3, 4}};

        int r = 1, c = 4;

        System.out.println(Arrays.deepToString(matrixReshape(nums, r, c)));
    }

    //Runtime: 1 ms, faster than 100.00% of Java
    private static int[][] matrixReshape( int[][] nums, int r, int c ) {

        int row = nums.length, col = nums[0].length;
        if (row * col != r * c)
            return nums;

        int[][] res = new int[r][c];

        int rowR = 0, colC = 0;

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {
                res[rowR][colC] = nums[i][j];

                colC++;
                if (colC == c) {
                    rowR++;
                    colC = 0;
                }
            }
        }

        return res;
    }
}
