package com.interview.leetcode.contests.biweekly.biweekely30;

import java.util.Arrays;

public class StoneGameIV {

    private static int dp[] = new int[100001];

    //https://leetcode.com/problems/stone-game-iv/
    //https://www.youtube.com/watch?v=rS7Ua0GmCYc&feature=youtu.be&t=1
    public static void main( String[] args ) {
        int n = 4;
        System.out.println(winnerSquareGame(n));
    }

    //Runtime: 76 ms, faster than 43.87% of Java
    private static boolean winnerSquareGame( int n ) {
        Arrays.fill(dp, -1);
        return help(n) == 1; //if other player has zero score, means we won.
    }

    private static int help( int n ) {
        if (n <= 0)
            return 0;

        if (dp[n] != -1)
            return dp[n];

        for (int i = 1; i * i <= n; i++) {
            //for each number {1..N} we are trying to pick square of each nums
            // 1*1 < n  -- 2*2 < n
            //if Bob got (4 - 2*2 == 0) then Alice won
            if (help(n - i * i) == 0)
                return dp[n] = 1;
        }

        return dp[n] = 0;
    }
}
