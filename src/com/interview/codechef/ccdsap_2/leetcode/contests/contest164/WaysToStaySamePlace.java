package com.interview.codechef.ccdsap_2.leetcode.contests.contest164;

import java.util.Arrays;

public class WaysToStaySamePlace {

    private static final int MOD = 1000000007;

    //https://leetcode.com/contest/weekly-contest-164/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
    public static void main( String[] args ) {
        int steps = 4, arrLen = 2;

        int[][] dp = new int[steps + 1][steps + 1];

        for (int[] arr : dp)
            Arrays.fill(arr, -1);

        System.out.println(dp(0, steps, arrLen, dp));
    }

    private static int dp( int i, int steps, int arrLen, int[][] memo ) {
        if (steps == 0 && i == 0)                                             //Base condition
            return 1;

        if (i < 0 || i >= arrLen || steps == 0 || i > steps)                    //Pruning.
            return 0;

        //If we have already cached the result for current `steps` and `index` get it.
        if (memo[i][steps] != -1)
            return memo[i][steps];

        return memo[i][steps] = ((dp(i + 1, steps - 1, arrLen, memo) % MOD +
                dp(i - 1, steps - 1, arrLen, memo)) % MOD +
                dp(i, steps - 1, arrLen, memo)) % MOD;        //Either move right, left or stay.

    }
}
