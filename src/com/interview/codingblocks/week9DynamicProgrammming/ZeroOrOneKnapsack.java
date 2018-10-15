package com.interview.codingblocks.week9DynamicProgrammming;

import java.util.Arrays;

public class ZeroOrOneKnapsack {

    //Given a bag of 10 kg and items are:
    //weight: 7  4 4
    //price : 15 8 8

    //If we use greedy, it picks price 15, and bag fills with weight:7

    //Now, if we use dp, it picks optimal weights : 8 8 and profit : 16.
    //So, we have to generate Subsets and check, which subset generate maximum profit.

    //Step1: Recurrence relation for adding the element into bag:
    //profit(n,10) = price [ n - 1 or last item ] + //include the current element
    //               profit( n - 1 , W - weight of last item ) //profit of remaining items: 10 - 6 = 4kg

    //Step2 : Recurrence for not adding element into bag:
    //profit(n,10) = 0 +
    //               profit( n - 1 , W = 10 ) //if we are not picking the weight

    //Final profit: Math.max(step1, step2)


    static int memo[][] = new int[100][100];

    //Video ref : https://www.youtube.com/watch?time_continue=11629&v=X7SrnbgqHHs
    public static void main( String[] args ) {

        //output: 40
        /*int[] weights = {2, 7, 3, 4};
        int[] prices = {5, 20, 20, 10};

        int N = 4; //number of items
        int W = 11; //Bag capacity
        */

        //output: 16
        int[] weights = {7, 4, 4};
        int[] prices = {15, 8, 8};

        int N = 3;
        int W = 10;

        long startTime = System.nanoTime();

        System.out.println(solveRecursive(weights, prices, N, W));

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Time Recursive: " + totalTime);

        //-----------------------------------------------------------------

        long startTimeMemoization = System.nanoTime();

        for (int[] row : memo)
            Arrays.fill(row, -1);

        System.out.println(solveTopDownDP(weights, prices, N, W));

        long endTimeMemoization = System.nanoTime();
        long totalTimeMemoization = endTimeMemoization - startTimeMemoization;
        System.out.println("Time Top Down DP : " + totalTimeMemoization);

        System.out.println(solveBottomUpDP(weights, prices, N, W));
    }

    //The include-exclude is same as : subsequences.java inside recursion
    private static int solveRecursive( int[] weights, int[] prices, int N, int W ) {

        //N==0 : if we have choose every items
        //W==0 : if knapsack has no weight to fill
        if (N == 0 || W == 0)
            return 0;

        int includeWeight = 0, excludeWeight = 0;

        //Step1:
        //if current element is fit into knapsack, then only pick element to include into Knapsack(bag)
        if (weights[N - 1] <= W)
            //N-1 : to pick next element
            //W - weights[N-1] : current weight can fit into knapsack, so reduce it from Total weight : W
            includeWeight = prices[N - 1] + solveRecursive(weights, prices, N - 1, W - weights[N - 1]);

        //Step2: exclude the current from knapsack: just to create subset and check if some other fits into bag.
        excludeWeight = 0 + solveRecursive(weights, prices, N - 1, W);

        return Math.max(includeWeight, excludeWeight);
    }

    //We have to work on two params, N & W , so we need 2D array to solve this.
    private static int solveTopDownDP( int weights[], int prices[], int N, int W ) {
        //N==0 : if we have choose every items
        //W==0 : if knapsack has no weight to fill
        if (N == 0 || W == 0)
            return 0;

        if (memo[N - 1][N - 1] != -1)
            return memo[N - 1][N - 1];

        int includeWeight = 0, excludeWeight;

        //Step1:
        //if current element is fit into knapsack, then only pick element to include into Knapsack(bag)
        if (weights[N - 1] <= W)
            //N-1 : to pick next element
            //W - weights[N-1] : current weight can fit into knapsack, so reduce it from Total weight : W
            includeWeight = prices[N - 1] + solveRecursive(weights, prices, N - 1, W - weights[N - 1]);

        //Step2: exclude the current from knapsack: just to create subset and check if some other fits into bag.
        excludeWeight = 0 + solveTopDownDP(weights, prices, N - 1, W);

        memo[N - 1][N - 1] = Math.max(includeWeight, excludeWeight);
        return memo[N - 1][N - 1];
    }


    //Video : https://www.youtube.com/watch?v=sVAB0p58tlg
    private static int solveBottomUpDP( int weights[], int prices[], int N, int W ) {

        //initialize dp array with W = total weights size
        int dp[][] = new int[prices.length + 1][W + 1];


        for (int i = 0; i <= prices.length; i++) {

            //Loop through Total weights given
            for (int j = 0; j <= W; j++) {


                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                int value;

                //if current weight is less than Sum of Weight
                if (weights[i - 1] <= j) {

                    int excludingTheCurrentWeight = dp[i - 1][j]; //copy the value from above cell

                    int includingTheCurrentWeight = prices[i-1]; //include the current price value
                    int remainingWeight = j - weights[i-1]; //for remaining weight: [sum of weight - current weight ]
                    int remainingPrice = dp[i - 1][remainingWeight];
                    includingTheCurrentWeight += remainingPrice;

                    value = Math.max(excludingTheCurrentWeight, includingTheCurrentWeight);
                } else {
                    value = dp[i - 1][j];
                }

                dp[i][j] = value;
            }
        }

        return dp[prices.length][W];
    }
}
