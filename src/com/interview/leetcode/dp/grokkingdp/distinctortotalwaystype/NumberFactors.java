package com.interview.leetcode.dp.grokkingdp.distinctortotalwaystype;

public class NumberFactors {

    /*
    Given a number ‘n’, implement a method to count how many possible ways there are to express ‘n’
    as the sum of 1, 3, or 4.

    n : 4
    Number of ways = 4
    Explanation: Following are the four ways we can exoress 'n' : {1,1,1,1}, {1,3}, {3,1}, {4}
     */
    public static void main( String[] args ) {
        NumberFactors en = new NumberFactors();

        int n = 4;

        int[] dp = new int[n + 1];
        System.out.println(en.CountWaysRecursive(dp, n));

        System.out.println(en.CountWays_1D_DP(n));
    }

    public int CountWaysRecursive( int[] dp, int n ) {
        if (n == 0)
            return 1; // base case, we don't need to subtract any thing, so there is only one way

        if (n == 1)
            return 1; // we can take subtract 1 to be left with zero, and that is the only way

        if (n == 2)
            return 1; // we can subtract 1 twice to get zero and that is the only way

        if (n == 3)
            return 2; // '3' can be expressed as {1,1,1}, {3}

        if (dp[n] == 0) {
            // if we subtract 1, we are left with 'n-1'
            int subtract1 = CountWaysRecursive(dp, n - 1);
            // if we subtract 3, we are left with 'n-3'
            int subtract3 = CountWaysRecursive(dp, n - 3);
            // if we subtract 4, we are left with 'n-4'
            int subtract4 = CountWaysRecursive(dp, n - 4);
            dp[n] = subtract1 + subtract3 + subtract4;
        }

        return dp[n];
    }

    public int CountWays_1D_DP( int n ) {

        //we have to find sum of 1, 3, or 4. So we define states dp[0]...dp[4]
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1; // {1}
        dp[2] = 1; // {1 ,1}
        dp[3] = 2; //{3}, {1,1,1}

        for (int i = 4; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4];

        return dp[n];
    }
}
