package com.interview.codechef.ccdsap_2.leetcode.dp.newproblems;

public class BestTimeBuySellStockII {

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
    public static void main( String[] args ) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    private static int maxProfit( int[] prices ) {

        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {

            if (prices[i + 1] > prices[i])
                total += prices[i + 1] - prices[i];

        }

        return total;
    }
}
