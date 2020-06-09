package com.interview.leetcode.dp.grokkingdp.unboundedknapscaktype;

public class HackerRankKnapsack {

    //https://www.hackerrank.com/challenges/unbounded-knapsack/problem
    public static void main( String[] args ) {

    }

    //In this question we can pick any number of profits[i] to generate the capacity. So it is an example of unbounded knapsack
    //Took ref of  UnBoundedKnapsack --> solveKnapsack_1D_DP_Again and solved it..

    //This problem can also be solved using CoinChangeMinCoins patterns..

    static int unboundedKnapsack( int capacity, int[] profits ) {
        //Arrays.sort(profits);

        int n = profits.length;
        int[] dp = new int[capacity + 1];
        int val = 0;

        for (int i = 0; i < n; i++) {

            for (int s = profits[i]; s <= capacity; s++) {

                int include = 0, exclude = 0;

                if (profits[i] <= s)
                    include = profits[i] + dp[s - profits[i]];

                if (i > 0)
                    exclude = dp[s];


                dp[s] = Math.max(exclude, include);
            }

            //val = Math.max(dp[i], val);
        }
        return dp[capacity];
    }


}
