package com.interview.codechef.ccdsap_2.leetcode.dp.newproblems;

public class BestTimeBuySellStockTransFee {

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/

    //Easy problem: Same as BestTimeBuySellStockCoolDown
    public static void main( String[] args ) {

        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }

    //so sell[i] : means profit calculated by selling at ith position
    //so buy[i] : means profit calculated by buying at ith position

    private static int maxProfit( int[] prices, int fee ) {
        if (prices == null || prices.length < 1) {
            return 0;
        }

        int length = prices.length;

        // buy[i]: max profit if the first "i" days end with a "buy" day
        int[] buy = new int[length + 1];

        // buy[i]: max profit if the first "i" days end with a "sell" day
        int[] sell = new int[length + 1];

        //buy profit is -ve of price for first stock..
        buy[1] = -prices[0];

        for (int i = 2; i <= length; i++) {
            int price = prices[i - 1];

            buy[i] = Math.max(buy[i - 1], sell[i - 1] - price); //sell[i-1] is diff from CoolDown
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + price - fee); //-fee is diff from CoolDown
        }

        // sell[length] >= buy[length] is always greater than buying
        return sell[length];
    }
}