package com.interview.codechef.ccdsap_2.leetcode.dp.easy;

import java.util.Arrays;

public class ClimbingStairs {

    //https://leetcode.com/problems/climbing-stairs/

    //same as MinStepToReach1
    public static void main( String[] args ) {
        int[] dp = new int[3];

        Arrays.fill(dp, -1);
        System.out.println(recurse(2, dp));

        System.out.println("bottomUpDP: " + bottomUpDP(3));
    }

    //Runtime: 0 ms, faster than 100.00% of Java
    //solved in one go, motivation from : MinStepToReach1
    private static int bottomUpDP( int n ) {

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        if (n == 1)
            return dp[1];

        dp[2] = dp[1] + dp[0];

        if (n == 2)
            return dp[2];

        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    private static int recurse( int n, int[] dp ) {
        if (n == 1 || n == 0)
            return 1;

        if (dp[n] != -1)
            return dp[n];

        return dp[n] = recurse(n - 1, dp) + recurse(n - 2, dp);
    }
}
