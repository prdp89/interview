package com.interview.codechef.ccdsapfoundation_1.DP.GFG;

import java.util.Arrays;

public class PathMaxAvgValue {

    //https://www.geeksforgeeks.org/path-maximum-average-value/
    public static void main( String[] args ) {
        int cost[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        int[][] dp = new int[cost.length + 1][cost.length + 1];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        System.out.println((float) maxPathAverageValue(cost, cost.length, 0, 0, dp) / (2 * cost.length - 1));
    }

    private static int maxPathAverageValue( int[][] cost, int length, int i, int j, int[][] dp ) {

        if (i >= length || j >= length)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (i == length - 1 && j == length - 1)
            return cost[i][j];

        return dp[i][j] = cost[i][j] +
                Math.max(maxPathAverageValue(cost, length, i, j + 1, dp)
                        , maxPathAverageValue(cost, length, i + 1, j, dp));
    }
}