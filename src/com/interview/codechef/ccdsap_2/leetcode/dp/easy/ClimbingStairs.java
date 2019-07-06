package com.interview.codechef.ccdsap_2.leetcode.dp.easy;

import java.util.Arrays;

public class ClimbingStairs {

    //https://leetcode.com/problems/climbing-stairs/

    public static void main( String[] args ) {
        int[] dp = new int[3];

        Arrays.fill(dp, -1);
        System.out.println(recurse(2, dp));
    }

    private static int recurse( int n, int[] dp ) {
        if (n == 1 || n == 0)
            return 1;

        if(dp[n] != -1)
            return dp[n];

        return dp[n] = recurse(n - 1, dp) + recurse(n - 2, dp);
    }
}
