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

        //System.out.println(recurse(grid, grid.length - 1, grid[0].length - 1, dp));

        System.out.println(bottomUP(grid));
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

    private static int bottomUP( int[][] grid ) {

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {

                //if first row then only way to go is forward direction.
                //so current grid[i][j] = previous col path sum
                if (i == 0 && j != 0)
                    grid[i][j] += grid[i][j - 1];


                //if we are in second row and zero-th col then we can move in downward direction
                //adding the upper row element with current.
                if (i != 0 && j == 0)
                    grid[i][j] += grid[i - 1][j];

                //if we are in second row and > zero-th column then we have 2 options:
                //either take upper row value or
                //take left col value.
                if (i != 0 && j != 0)
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }
}
