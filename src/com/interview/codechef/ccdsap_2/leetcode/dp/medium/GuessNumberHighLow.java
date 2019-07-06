package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

public class GuessNumberHighLow {

    //https://leetcode.com/problems/guess-number-higher-or-lower-ii/
    public static void main( String[] args ) {
        System.out.println(getMoneyAmount(10));
    }

    private static int getMoneyAmount( int n ) {
        int[][] table = new int[n + 1][n + 1];
        return recurse(table, 1, n);
    }

    //ref: https://leetcode.com/problems/guess-number-higher-or-lower-ii/discuss/84764/Simple-DP-solution-with-explanation~~
    private static int recurse( int[][] t, int s, int e ) {

        if (s >= e) return 0;

        if (t[s][e] != 0) return t[s][e];

        int res = Integer.MAX_VALUE;

        for (int x = s; x <= e; x++) {
            //Given num 1...N
            //Case 1: If we pick 5, we can pick 1...4 or
            //Case 2: Or We can pick in Range from 5...N
            int tmp = x + Math.max(recurse(t, s, x - 1), recurse(t, x + 1, e));

            //Min is taken to Minimize the cost/money
            res = Math.min(res, tmp);
        }

        t[s][e] = res;
        return res;
    }
}
