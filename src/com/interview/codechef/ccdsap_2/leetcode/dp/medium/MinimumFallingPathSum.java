package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.Arrays;

public class MinimumFallingPathSum {

    //https://leetcode.com/problems/minimum-falling-path-sum/

    //THis question is similar as Triangle
    public static void main( String[] args ) {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };  //op : 3

        System.out.println(minFallingPathSum(grid));
    }

    //ref: https://leetcode.com/problems/minimum-falling-path-sum/discuss/186651/Java-two-clean-DP-codes-input-modified-and-not-Time-O(n-2)-space-O(1)-and-O(n)
    private static int minFallingPathSum( int[][] A ) {
        int n = A.length;

        //starting from second row
        for (int i = 1; i < n; ++i) {

            for (int j = 0; j < n; ++j) {

                //for baseElement getting the upper row num
                int minOfAbove3 = A[i - 1][j];

                //if above row left element is less than MIN
                if (j > 0 && A[i - 1][j - 1] < minOfAbove3) {
                    minOfAbove3 = A[i - 1][j - 1];
                }


                //if above row right element is less than MIN
                if (j + 1 < n && A[i - 1][j + 1] < minOfAbove3) {
                    minOfAbove3 = A[i - 1][j + 1];
                }

                A[i][j] += minOfAbove3;
            }
        }
        return Arrays.stream(A[n - 1]).min().getAsInt();
    }
}
