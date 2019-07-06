package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.Arrays;

public class MinimumPathSum {

    //https://leetcode.com/problems/minimum-path-sum/
    public static void main( String[] args ) {

        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        int[][] dp = new int[grid.length + 1][grid[0].length + 1];

        for (int[] dsp : dp) {
            Arrays.fill(dsp, -1);
        }

        System.out.println(recurse(grid, grid.length - 1, grid[0].length - 1, dp));
    }

    private static int recurse( int[][] grid, int i, int j, int[][] dp ) {

        if (i == 0 && j == 0)
            return grid[i][j];

        if (i < 0 || j < 0) {
            //since we need to Find Min Sum path, returning Zero lead to incorrect result
            //return 0;
            return Integer.MAX_VALUE;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        return dp[i][j] = grid[i][j] + Math.min(recurse(grid, i - 1, j, dp), recurse(grid, i, j - 1, dp));
    }
}
