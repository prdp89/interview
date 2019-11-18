package com.interview.codechef.ccdsap_2.atcoder.educationalDPContest;

import java.util.Scanner;

//https://atcoder.jp/contests/dp/tasks/dp_h
public class Grid1 {

    private final static long MOD = (long) 1e9 + 7;

    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        char[][] grid = new char[n][m];

        for (int i = 0; i < n; i++) {
            grid[i] = scanner.next().toCharArray();
        }

        Long[][] dp = new Long[n][m];

        System.out.println(recurse(0, 0, n, m, dp, grid));
    }

    //ref: https://atcoder.jp/contests/dp/submissions/6783427
    private static long recurse( int row, int col, int n, int m, Long[][] dp, char[][] grid ) {
        if (row == n - 1 && col == m - 1)
            return 1;

        if (dp[row][col] != null)
            return dp[row][col];

        long ans = 0;
        if (row + 1 < n && grid[row + 1][col] == '.') {
            ans += recurse(row + 1, col, n, m, dp, grid);
            ans %= MOD;
        }

        if (col + 1 < m && grid[row][col + 1] == '.') {
            ans += recurse(row, col + 1, n, m, dp, grid);
            ans %= MOD;
        }

        return dp[row][col] = ans;
    }
}
