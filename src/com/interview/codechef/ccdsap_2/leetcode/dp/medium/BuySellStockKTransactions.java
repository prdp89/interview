package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.Arrays;

public class BuySellStockKTransactions {

    private static int fees = 0;

    public static void main( String[] args ) {
        int[] arr = {1, 3, 2, 8, 4, 9};

        int[][] dp = new int[arr.length + 1][arr.length + 1];

        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        fees = 2;

        int res = recurse(arr, 0, dp);
        System.out.println(res);
    }

    //recursion working correctly but TLE
    //Dp not working...

    //understand this for bottom up states: https://stackoverflow.com/questions/56555654/buy-sell-stock-with-transaction-fee
    private static int recurse( int[] prices, int index, int[][] dp ) {

        if (index == prices.length - 1) {
            return 0;
        }

        int profit = 0, min = Integer.MAX_VALUE;

        int m = index;
        for (; m < prices.length; m++) {

            min = Math.min(min, prices[m]);//picking at min prices

            int diff = prices[m] - min;//diff. for current min. picked stock profit

            if (dp[m][index] != -1)
                return dp[m][index];

            if (diff > 0) {
                diff += recurse(prices, m + 1, dp);
            }

            profit = Math.max(profit, diff - fees);
        }

        dp[m][index] = profit;

        return profit;
    }
}
