package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

public class UniquePaths {

    //https://leetcode.com/problems/unique-paths/
    //same as : com.interview.codechef.ccdsapfoundation_1.recurse.GFG : UniquePathInGrid;
    public static void main( String[] args ) {
        int[][] arr = new int[3][2];
        System.out.println(recurse(3, 2));
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
