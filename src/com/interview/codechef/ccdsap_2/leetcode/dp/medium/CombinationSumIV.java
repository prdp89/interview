package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.Arrays;

public class CombinationSumIV {

    private static int[] dp;

    //https://leetcode.com/problems/combination-sum-iv/
    public static void main( String[] args ) {
        int[] arr = {1, 2, 3};
        int target = 4;

        dp = new int[target + 1];

        Arrays.fill(dp, -1);

        System.out.println(recursive(arr, target));

        System.out.println("bottomUpDp : " + bottomUpDp(arr, target));
    }

    //This is same as CoinChangeMinCoins
    //Runtime: 1 ms, faster than 82.18% of Java
    private static int bottomUpDp( int[] arr, int amount ) {

        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int i = 1; i <= amount; i++) {

            // For each coin we are given
            for (int j = 0; j < arr.length; j++) {
                // If it is less than or equal to the sub problem amount
                if (arr[j] <= i) {
                    // Try it. See if it gives us a more optimal solution
                    dp[i] = dp[i] + dp[i - arr[j]];
                }
            }
        }

        return dp[amount];
    }

    //This question is different from CombinationSum bcz we are counting the sequence of different order with duplicate values as well.
    //Runtime: 0 ms, faster than 100.00% of Java
    private static int recursive( int[] arr, int target ) {

        if (dp[target] != -1)
            return dp[target];

        if (target <= 0)
            return 1;

        int res = 0;

        //This loop should starts with zero in-case we want duplicate sequence
        for (int i = 0; i < arr.length; i++) {
            if (target >= arr[i]) //picking only that element which is smaller than target
                res += recursive(arr, target - arr[i]);
        }

        dp[target] = res;
        return res;
    }
}
