package com.interview.leetcode.contests.biweekly.biweekely34;

public class DiagonalSum {

    //https://leetcode.com/contest/biweekly-contest-34/problems/matrix-diagonal-sum/
    public static void main( String[] args ) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(diagonalSum(arr));
    }

    //Runtime: 1 ms
    private static int diagonalSum( int[][] mat ) {

        int sum = 0;

        for (int i = 0; i < mat.length; i++) {

            for (int j = 0; j < mat[i].length; j++) {

                if (i == j) {
                    sum += mat[i][j];
                    mat[i][j] = 0;
                } else if (i + j == mat.length - 1) {
                    sum += mat[i][j];
                    mat[i][j] = 0;
                }
            }
        }

        return sum;
    }

    public int diagonalSum_optimal( int[][] mat ) {
        int n = mat.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += mat[i][i] + mat[i][n - 1 - i];
        }
        return n % 2 == 1 ? sum - mat[n / 2][n / 2] : sum;
    }
}
