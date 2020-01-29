package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

public class CoinChangeTotalWays {

    //https://leetcode.com/problems/coin-change-2/
    public static void main( String[] args ) {

        //The backtrack method can be written as: CombinationSum
        //https://leetcode.com/problems/combination-sum/

        //NOw the DP way:
        int[] arr = {1, 2, 5};
        int amount = 5;

        System.out.println(bottomUpDp(arr, amount));
    }

    //This pattern is again based on Inclusion-Exclusion principle
    //The same pattern has been used in Knapsack1 -> bottomup-Dp solution and TargetSum

    //Time/Space Complexity
    //Time Complexity: O(amount * coins)
    //Space Complexity: O(amount)
    private static int bottomUpDp( int[] arr, int amount ) {

        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int i = 0; i < arr.length; i++) {

            //inner loop is almost same as KnapSack1
            //see carefully : we are starting from : arr[i]
            //go till : amount
            //this means we can pick duplicate values..
            for (int j = arr[i]; j <= amount; j++) {

                //for (int j = amount; j >= arr[i]; j--) {

                dp[j] = dp[j] + dp[j - arr[i]];
            }
        }

        return dp[amount];
    }

    //using 2D dp, same inclusion-exclusion principle..
    //ref: https://www.youtube.com/watch?v=DJ4a7cmjZY0
    public int change( int amount, int[] coins ) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= coins.length; i++) {

            dp[i][0] = 1;

            for (int currAmt = 1; currAmt <= amount; currAmt++) {

                int coinVal = coins[i - 1];
                int leaveThisCoin = dp[i - 1][currAmt];

                if (coinVal > currAmt) {
                    dp[i][currAmt] = leaveThisCoin;
                } else {
                    //same as dp[j - arr[i]]
                    int takeThisCoin = dp[i][currAmt - coinVal];

                    dp[i][currAmt] = leaveThisCoin + takeThisCoin;
                }
            }
        }

        return dp[coins.length][amount];
    }
}
