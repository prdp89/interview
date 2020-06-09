package com.interview.leetcode.dp.grokkingdp.unboundedknapscaktype;

public class UnBoundedKnapsack {

    //https://www.hackerrank.com/challenges/unbounded-knapsack/
    public static void main( String[] args ) {
        UnBoundedKnapsack ks = new UnBoundedKnapsack();
        int[] profits = {15, 50, 60, 90};
        int[] weights = {1, 3, 4, 5};
        System.out.println(ks.solveKnapsack_TopDown_DP(profits, weights, 8));

        System.out.println(ks.solveKnapsack_2D_DP(profits, weights, 8));

        System.out.println(ks.solveKnapsack_1D_DP_Again(profits, weights, 8));
    }

    public int solveKnapsack_TopDown_DP( int[] profits, int[] weights, int capacity ) {
        Integer[][] dp = new Integer[profits.length][capacity + 1];
        return this.knapsackRecursive(dp, profits, weights, capacity, 0);
    }

    private int knapsackRecursive( Integer[][] dp, int[] profits, int[] weights, int capacity,
                                   int currentIndex ) {

        // base checks
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length ||
                currentIndex >= profits.length)
            return 0;

        // check if we have not already processed a similar sub-problem
        if (dp[currentIndex][capacity] == null) {
            // recursive call after choosing the items at the currentIndex, note that we recursive call on all
            // items as we did not increment currentIndex
            int profit1 = 0;
            if (weights[currentIndex] <= capacity)
                profit1 = profits[currentIndex] + knapsackRecursive(dp, profits, weights,
                        capacity - weights[currentIndex], currentIndex); //diff. with ZeroOneKnapSack

            // recursive call after excluding the element at the currentIndex
            int profit2 = knapsackRecursive(dp, profits, weights, capacity, currentIndex + 1);

            dp[currentIndex][capacity] = Math.max(profit1, profit2);
        }

        return dp[currentIndex][capacity];
    }

    public int solveKnapsack_2D_DP( int[] profits, int[] weights, int capacity ) {
        // base checks
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;

        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];

        // populate the capacity=0 columns : even we don't need this
        //for (int i = 0; i < n; i++)
        //  dp[i][0] = 0;

        //if we have only one weight, we will take it if it is not more than the capacity
        //we did not check this condition, here...

        // process all sub-arrays for all capacities
        for (int i = 0; i < n; i++) { //loop starts with zero, diff from ZeroOneKnapSack

            for (int c = 1; c <= capacity; c++) {

                int profit1 = 0, profit2 = 0;

                if (weights[i] <= c)
                    profit1 = profits[i] + dp[i][c - weights[i]]; //no 'i-1' here...

                if (i > 0)
                    profit2 = dp[i - 1][c];

                dp[i][c] = Math.max(profit1, profit2);
            }
        }

        // maximum profit will be in the bottom-right corner.
        return dp[n - 1][capacity];
    }

    //took ref. from CoinChangeTotalWays and try'n...it is correct :)
    public int solveKnapsack_1D_DP_Again( int[] profits, int[] weights, int capacity ) {
        // base checks
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;

        int n = profits.length;
        int[] dp = new int[capacity + 1];

        // process all sub-arrays for all the capacities
        for (int i = 0; i < n; i++) {

            for (int s = weights[i]; s <= capacity; s++) { //only this loop differ in UnBounded knapsac
                int include = 0, exclude = 0;

                if (weights[i] <= s)
                    include = profits[i] + dp[s - weights[i]];

                if (i > 0)
                    exclude = dp[s];

                dp[s] = Math.max(exclude, include);
            }
        }
        return dp[capacity];
    }
}
