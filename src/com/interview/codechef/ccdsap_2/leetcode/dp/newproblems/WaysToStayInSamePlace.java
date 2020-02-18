package com.interview.codechef.ccdsap_2.leetcode.dp.newproblems;

import java.util.Arrays;

public class WaysToStayInSamePlace {

    private static int MOD = (int) 1e9 + 7;

    //https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
    public static void main( String[] args ) {
        int steps = 4, arrLen = 2;

        int[][] memo = new int[arrLen + 1][steps + 1];

        for (int[] arr : memo)
            Arrays.fill(arr, -1);

        dp(0, steps, arrLen, memo);

        System.out.println(memo[0][steps]);

        System.out.println("Bottom up DP : " + numWaysBottomUpDP(steps, arrLen));
        //System.out.println();
    }

    //https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/discuss/436117/C%2B%2B-Recursive-DP-(Memoization)
    private static int dp( int i, int steps, int arrLen, int[][] memo ) {
        if (steps == 0 && i == 0)                                             //Base condition
            return 1;

        if (i < 0 || i >= arrLen || steps == 0 || i > steps)                    //Pruning.
            return 0;

        if (memo[i][steps] != -1)         //If we have already cached the result for current `steps` and `index` get it.
            return memo[i][steps];

        return memo[i][steps] = ((dp(i + 1, steps - 1, arrLen, memo) % MOD
                + dp(i - 1, steps - 1, arrLen, memo)) % MOD
                + dp(i, steps - 1, arrLen, memo)) % MOD;        //Either move right, left or stay.
    }

    private static int numWaysBottomUpDP( int steps, int n ) {

        int[] dp = new int[n];

        if (n <= 1)
            return n;

        //if array has zero element, ways to reach zero element
        dp[0] = 1;

        //if array has one element, ways to reach zero element
        dp[1] = 1;

        //bcz running till N cause TLE
        int maxPos = Math.min(steps, n);

        //we have to run till steps
        for (int j = 1; j < steps; j++) {

            int[] temp = new int[n];

            /*
            And the main part, transition functions:

            long ans = dp[i] means we take Stay as our current action
            ans + dp[i - 1] means we take Right as our current action
            ans + dp[i + 1] means we take Left as our current action
             */
            for (int i = 0; i < maxPos; i++) { //we are running till array length
                long ans = dp[i];

                if (i > 0)
                    ans = (ans + dp[i - 1]) % MOD;

                if (i < n - 1)
                    ans = (ans + dp[i + 1]) % MOD;

                temp[i] = (int) ans;
            }

            dp = temp;
        }

        //why dp[0] : bcz we have return steps to reach till dp[0]
        return dp[0];
    }
}
