package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.Arrays;

public class BuySellStockWithCoolDown {

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
    public static void main( String[] args ) {
        int[] arr = {1, 2, 3, 0, 2};

        int[] dp = new int[arr.length + 1];

        Arrays.fill(dp, -1);
        System.out.println(recurse(arr, 0, dp));
    }

    private static int recurse( int[] prices, int index, int[] dp ) {

        if (index == prices.length - 1) {
            return 0;
        }

        if (index < dp.length && dp[index] != -1)
            return dp[index];

        int profit = 0, min = Integer.MAX_VALUE;

        for (int m = index; m < prices.length; m++) {

            min = Math.min(min, prices[m]);//picking at min prices

            int diff = prices[m] - min;//diff. for current min. picked stock profit

            if (diff > 0) {
                diff += recurse(prices, m + 2, dp);
            }
            profit = Math.max(profit, diff);
        }

        if (index < dp.length)
            dp[index] = profit;

        return profit;
    }
}
