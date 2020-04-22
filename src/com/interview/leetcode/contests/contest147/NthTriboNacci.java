package com.interview.leetcode.contests.contest147;

public class NthTriboNacci {

    //https://leetcode.com/contest/weekly-contest-147/problems/n-th-tribonacci-number
    public static void main( String[] args ) {
        int n = 25;
        int[] dp = new int[38];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        System.out.println(dp[n]);
    }
}