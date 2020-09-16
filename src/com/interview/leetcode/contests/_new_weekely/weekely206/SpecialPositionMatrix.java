package com.interview.leetcode.contests._new_weekely.weekely206;

public class SpecialPositionMatrix {

    //https://leetcode.com/contest/weekly-contest-206/problems/special-positions-in-a-binary-matrix/
    public static void main( String[] args ) {
        int[][] mat = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

        System.out.println(numSpecial(mat));
        System.out.println(numSpecial_optimal(mat));
    }

    //95 / 95 test cases passed.Status: Accepted Runtime: 6 ms
    private static int numSpecial( int[][] mat ) {
        int ans = 0;

        for (int i = 0; i < mat.length; i++) {

            for (int j = 0; j < mat[i].length; j++) {

                if (mat[i][j] == 1) {
                    int rows = 0, cols = 0;
                    for (int k = 0; k < mat[i].length; k++) {
                        if (mat[i][k] == 1)
                            rows++;
                    }

                    for (int k = 0; k < mat.length; k++) {
                        if (mat[k][j] == 1)
                            cols++;
                    }

                    if (rows == 1 && cols == 1)
                        ans++;
                }
            }
        }

        return ans;
    }

    //Runtime: 2 ms, faster than 25.00% of Java
    private static int numSpecial_optimal( int[][] mat ) {
        int r = mat.length, c = mat[0].length;

        int[] row = new int[r], col = new int[c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1)
                    count++;

        return count;
    }
}
