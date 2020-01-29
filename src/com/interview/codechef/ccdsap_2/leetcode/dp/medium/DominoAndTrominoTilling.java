package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

public class DominoAndTrominoTilling {

    //https://leetcode.com/problems/domino-and-tromino-tiling/
    public static void main( String[] args ) {
        int n = 5;

        System.out.println(bottomUpDP(n));
    }

    //For number of ways problem we always consider dp[0] = 1
    //If n = 1 then dp[1] = 1 { | : only one way}
    //If n = 2 then dp[2] = 2 { || , -_ : only two ways}
    //If n = 3 then dp[3] = 5 { ||| , -_| , |-_ , |- -|, |_ -|  : only five ways}

    //so, d[n] = 2 * dp[n-1] + dp[n-3]
    private static int bottomUpDP( int n ) {

        int mod = (int) Math.pow(10, 9) + 7;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        for (int i = 4; i <= n; i++) {
            dp[i] = 2 * dp[i - 1] + dp[i - 3];
            dp[i] %= mod;
        }

        return dp[n];
    }
}
