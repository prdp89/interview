package com.interview.leetcode.dp.grokkingdp.boundedknapsacktype;

public class ZeroOneKnapsack {

    /*
    Given the weights and profits of ‘N’ items, we are asked to put these items in a knapsack which has a capacity ‘C’. The goal is to get the maximum profit from the items in the knapsack. Each item can only be selected once, as we don’t have multiple quantities of any item.

    Let’s take the example of Merry, who wants to carry some fruits in the knapsack to get maximum profit. Here are the weights and profits of the fruits:

    Items: { Apple, Orange, Banana, Melon }
    Weights: { 2, 3, 1, 4 }
    Profits: { 4, 5, 3, 7 }
    Knapsack capacity: 5

    Apple + Orange (total weight 5) => 9 profit
    Apple + Banana (total weight 3) => 7 profit
    Orange + Banana (total weight 4) => 8 profit
    Banana + Melon (total weight 5) => 10 profit
     */
    public static void main( String[] args ) {
        ZeroOneKnapsack ks = new ZeroOneKnapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};

        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit TOP DOWN---> " + maxProfit);

        int maxProfit2DDP = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit 2D DP---> " + maxProfit2DDP);

        int maxProfit2DDPSpace = ks.solveKnapsack_2d_Space_Optimized(profits, weights, 7);
        System.out.println("Total knapsack profit 2D DP Space Optimized---> " + maxProfit2DDPSpace);

        int maxProfit1DDP = ks.solveKnapsack_1D_DP(profits, weights, 7);
        System.out.println("Total knapsack profit 2D DP Space Optimized---> " + maxProfit1DDP);
    }

    private int solveKnapsack_2d_Space_Optimized( int[] profits, int[] weights, int capacity ) {
        // basic checks
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;

        int n = profits.length;
        // we only need one previous row to find the optimal solution, overall we need '2' rows
        // the above solution is similar to the previous solution, the only difference is that
        // we use `i%2` instead if `i` and `(i-1)%2` instead if `i-1`
        int[][] dp = new int[2][capacity + 1];

        // if we have only one weight, we will take it if it is not more than the capacity
        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c)
                dp[0][c] = dp[1][c] = profits[0];
        }

        // process all sub-arrays for all the capacities
        for (int i = 1; i < n; i++) {
            for (int c = 0; c <= capacity; c++) {
                int profit1 = 0, profit2 = 0;
                // include the item, if it is not more than the capacity
                if (weights[i] <= c)
                    profit1 = profits[i] + dp[(i - 1) % 2][c - weights[i]];
                // exclude the item
                profit2 = dp[(i - 1) % 2][c];
                // take maximum
                dp[i % 2][c] = Math.max(profit1, profit2);
            }
        }

        return dp[(n - 1) % 2][capacity];
    }

    public int solveKnapsack( int[] profits, int[] weights, int capacity ) {
        Integer[][] dp = new Integer[profits.length][capacity + 1];
        return this.knapsackRecursive(dp, profits, weights, capacity, 0);
    }

    private int knapsackRecursive( Integer[][] dp, int[] profits, int[] weights, int capacity,
                                   int currentIndex ) {

        // base checks
        if (capacity <= 0 || currentIndex >= profits.length)
            return 0;

        // if we have already solved a similar problem, return the result from memory
        if (dp[currentIndex][capacity] != null)
            return dp[currentIndex][capacity];

        // recursive call after choosing the element at the currentIndex
        // if the weight of the element at currentIndex exceeds the capacity, we shouldn't process this
        int profit1 = 0;
        if (weights[currentIndex] <= capacity)
            profit1 = profits[currentIndex] + knapsackRecursive(dp, profits, weights,
                    capacity - weights[currentIndex], currentIndex + 1);

        // recursive call after excluding the element at the currentIndex
        int profit2 = knapsackRecursive(dp, profits, weights, capacity, currentIndex + 1);

        dp[currentIndex][capacity] = Math.max(profit1, profit2);
        return dp[currentIndex][capacity];
    }

    public int solveKnapsack_2D_BottomUP( int[] profits, int[] weights, int capacity ) {
        // basic checks
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;

        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];

        // populate the capacity=0 columns, with '0' capacity we have '0' profit
        for (int i = 0; i < n; i++)
            dp[i][0] = 0;

        // if we have only one weight, we will take it if it is not more than the capacity
        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c)
                dp[0][c] = profits[0];
        }

        // process all sub-arrays for all the capacities
        for (int i = 1; i < n; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1 = 0, profit2 = 0;
                // include the item, if it is not more than the capacity
                if (weights[i] <= c)
                    profit1 = profits[i] + dp[i - 1][c - weights[i]];
                // exclude the item
                profit2 = dp[i - 1][c];
                // take maximum
                dp[i][c] = Math.max(profit1, profit2);
            }
        }

        // maximum profit will be at the bottom-right corner.
        return dp[n - 1][capacity];
    }

    private int solveKnapsack_1D_DP( int[] profits, int[] weights, int capacity ) {
        // basic checks
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;

        int n = profits.length;
        int[] dp = new int[capacity + 1];

        // if we have only one weight, we will take it if it is not more than the
        // capacity
        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c)
                dp[c] = profits[0];
        }

        // process all sub-arrays for all the capacities
        for (int i = 1; i < n; i++) {

            for (int c = capacity; c >= 0; c--) {

                int profit1 = 0, profit2 = 0;

                // include the item, if it is not more than the capacity
                if (weights[i] <= c)
                    profit1 = profits[i] + dp[c - weights[i]];

                // exclude the item
                profit2 = dp[c];

                // take maximum
                dp[c] = Math.max(profit1, profit2);
            }
        }

        return dp[capacity];
    }
}
