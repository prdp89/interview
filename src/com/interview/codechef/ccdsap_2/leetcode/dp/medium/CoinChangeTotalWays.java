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
            for (int j = arr[i]; j <= amount; j++) {

                //for (int j = amount; j >= arr[i]; j--) {

                dp[j] = dp[j] + dp[j - arr[i]];
            }
        }

        return dp[amount];
    }
}
