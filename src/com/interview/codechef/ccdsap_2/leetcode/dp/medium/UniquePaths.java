package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

public class UniquePaths {

    //https://leetcode.com/problems/unique-paths/
    //same as : com.interview.codechef.ccdsapfoundation_1.recurse.GFG : UniquePathInGrid;
    public static void main( String[] args ) {
        int[][] arr = new int[3][2];
        System.out.println(recurse(3, 2));

        //System.out.println(bottomUpDP(3, 7)); //op : 28
        System.out.println(bottomUpDP(2, 3)); //op : 3
    }

    //Runtime: 0 ms, faster than 100.00% of Java
    //Memory Usage: 33.5 MB, less than 5.10% of Java
    //solved with little help, understood..
    private static int bottomUpDP( int m, int n ) {

        int[][] dp = new int[m][n];

        for (int i = 1; i < dp.length; i++) {

            for (int j = 1; j < dp[i].length; j++) {

                //total : cost of coming from up + coming from right + 1
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + 1;
            }
        }

        //simple explanation : number of ways are previous number of ways + 1
        return dp[m - 1][n - 1] + 1;
    }

    private static int recurse( int n, int m ) {

        if (n == 0 && m == 0)
            return 1;

        if (n == 0 || m == 0)
            return 0;

        if (n > 0 && m > 0)
            return recurse(n - 1, m) + recurse(n, m - 1);

        return 0;
    }
}
