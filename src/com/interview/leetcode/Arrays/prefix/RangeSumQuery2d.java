package com.interview.leetcode.Arrays.prefix;

public class RangeSumQuery2d {

    //https://leetcode.com/problems/range-sum-query-2d-immutable/
    private int[][] sum;

    private RangeSumQuery2d( int[][] matrix ) {
        if (matrix.length == 0)
            return;
        int m = matrix.length, n = matrix[0].length;

        sum = new int[m + 1][n + 1]; // sum[i][j] is sum of all elements from rectangle (0,0,i,j) as left, top, right, bottom corresponding

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public static void main( String[] args ) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        RangeSumQuery2d rangeSumQuery2d = new RangeSumQuery2d(matrix);
        System.out.println(rangeSumQuery2d.sumRegion(2, 1, 4, 3));
    }

    private int sumRegion( int r1, int c1, int r2, int c2 ) {
        r1++;
        c1++;
        r2++;
        c2++; // Since `sum` start with 1 so we need to increase r1, c1, r2, c2 by 1

        return sum[r2][c2] - sum[r2][c1 - 1] - sum[r1 - 1][c2] + sum[r1 - 1][c1 - 1];
    }
}
