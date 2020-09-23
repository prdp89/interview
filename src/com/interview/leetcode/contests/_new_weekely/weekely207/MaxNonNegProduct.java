package com.interview.leetcode.contests._new_weekely.weekely207;

public class MaxNonNegProduct {

    //https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/
    public static void main( String[] args ) {
        int[][] grid = {
                {1, -2, 1},
                {1, -2, 1},
                {3, -4, 1}
        };

        System.out.println(maxProductPath(grid));
        System.out.println(maxProductPath_optimal(grid));
    }

    //doesn't work with 2 states
    private static int maxProductPath( int[][] g ) {
        int m = g.length, n = g[0].length, mod = 1_000_000_007;

        long dp[][] = new long[m][n];

        dp[0][0] = g[0][0];

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) continue;

                long a = 0, b = 0;

                if (i == 0) {
                    dp[i][j] = g[i][j] * dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = g[i][j] * dp[i - 1][j];
                } else {
                    a = g[i][j] * Math.max(dp[i][j - 1], dp[i - 1][j]);
                    b = g[i][j] * Math.min(dp[i][j - 1], dp[i - 1][j]);

                    dp[i][j] = Math.max(a, b);
                    //  dp[i][j][1] = Math.min(a, b);
                }
            }
        }

        if (dp[m - 1][n - 1] < 0) return -1;
        return (int) ((dp[m - 1][n - 1]) % mod);
    }

    //Runtime: 1 ms, faster than 100.00% of Java
    //dp[i][j][1] is the minimum value you can get when you reach g[i][j]
    // , dp[i][j][0] is the max, similarly.
    private static int maxProductPath_optimal( int[][] g ) {
        int m = g.length, n = g[0].length, mod = 1_000_000_007;
        long[][][] dp = new long[m][n][2];

        dp[0][0] = new long[]{g[0][0], g[0][0]};

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) continue;

                long a = 0, b = 0;

                if (i == 0) {
                    dp[i][j][0] = dp[i][j][1] = g[i][j] * dp[i][j - 1][0];
                } else if (j == 0) {
                    dp[i][j][0] = dp[i][j][1] = g[i][j] * dp[i - 1][j][0];
                } else {
                    a = g[i][j] * Math.max(dp[i][j - 1][0], dp[i - 1][j][0]);
                    b = g[i][j] * Math.min(dp[i][j - 1][1], dp[i - 1][j][1]);

                    dp[i][j][0] = Math.max(a, b);
                    dp[i][j][1] = Math.min(a, b);
                }
            }
        }

        if (dp[m - 1][n - 1][0] < 0)
            return -1;

        return (int) ((dp[m - 1][n - 1][0]) % mod);
    }
}
