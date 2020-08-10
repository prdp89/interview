package com.interview.leetcode.dp.grokkingdp.unboundedknapscaktype;

public class CoinChangeWays {

    //https://leetcode.com/problems/coin-change-2/
    public static void main( String[] args ) {
        CoinChangeWays cc = new CoinChangeWays();
        int[] denominations = {1, 2, 3};

        System.out.println(cc.countChange(denominations, 5));

        System.out.println(cc.countChange_2D_DP(denominations, 5));
    }

    public int countChange( int[] denominations, int total ) {
        Integer[][] dp = new Integer[denominations.length][total + 1];
        return this.countChangeRecursive(dp, denominations, total, 0);
    }

    private int countChangeRecursive( Integer[][] dp, int[] denominations, int total, int currentIndex ) {
        // base checks
        if (total == 0)
            return 1;

        if (denominations.length == 0 || currentIndex >= denominations.length)
            return 0;

        // if we have already processed a similar sub-problem, return the result from memory
        if (dp[currentIndex][total] != null)
            return dp[currentIndex][total];

        // recursive call after selecting the coin at the currentIndex
        // if the number at currentIndex exceeds the total, we shouldn't process this
        int sum1 = 0;
        if (denominations[currentIndex] <= total) //same as UnBoundedKnapsack: we never increment currentIndex..
            sum1 = countChangeRecursive(dp, denominations, total - denominations[currentIndex], currentIndex);

        // recursive call after excluding the number at the currentIndex
        int sum2 = countChangeRecursive(dp, denominations, total, currentIndex + 1);

        dp[currentIndex][total] = sum1 + sum2;
        return dp[currentIndex][total];
    }

    //Runtime: 10 ms, faster than 23.26% of Java
    public int countChange_2D_DP( int[] denominations, int total ) {
        int n = denominations.length;
        int[][] dp = new int[n][total + 1];

        // populate the total=0 columns, as we will always have an empty set for zero total
        //Meaning, if we have total = 0 and set = {{1}, {1,2}, {1,2,3}}, it is always 1 ways to form it.
        for (int i = 0; i < n; i++)
            dp[i][0] = 1; //in case of number of ways problems, this is mandatory..

        // process all sub-arrays for all capacities
        for (int i = 0; i < n; i++) { //index i starts form 0 incase of unbounded knapsack..

            for (int t = 1; t <= total; t++) {

                if (i > 0)
                    dp[i][t] = dp[i - 1][t];

                if (t >= denominations[i])
                    dp[i][t] += dp[i][t - denominations[i]];
            }
        }

        // total combinations will be at the bottom-right corner.
        return dp[n - 1][total];
    }

    //1D Dp : com.interview.codechef.ccdsap_2.leetcode.dp.medium --> CoinChangeTotalWays --> bottomUpDp
}
