package com.interview.codechef.ccdsapfoundation_1.DP.GFG;

public class DiffWaysToSumN {

    //https://www.geeksforgeeks.org/different-ways-sum-n-using-numbers-greater-equal-m/
    public static void main( String[] args ) {
        // System.out.println(recurse(3, 1, 0, 0, 0));

        System.out.println(recurse(3, 1));
    }

    /*
    the number of partitions of n into k non-zero parts, then p(n,k) satisfies the recurrence relation
     */
    //working code.........
    private static int recurse( int n, int k ) {

        if (n == k)
            return 1;

        if (k > n)
            return 0;

        return recurse(n, k + 1) + recurse(n - k, k);
    }

    //not working..........
    private static int recurse( int N, int M, int ways, int index, int sum ) {

        if (sum == 0)
            return 1;

        if (index >= N)
            return 0;

        for (int i = 1; i <= N; i++) {

            if (i >= M)
                return 1 + recurse(N, M, ways + 1, i, N - i);
        }

        //int ways = recurse(N, M, ways, index+1, sum-)

        return 0;
    }
}
