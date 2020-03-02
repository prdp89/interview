package com.interview.codechef.ccdsap_2.leetcode.dp.newproblems;

public class BestTimeBuySellStockCoolDown {

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

    //Easy problem: Read comment carefully
    public static void main( String[] args ) {

        System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

    //ref: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75927/Share-my-thinking-process
    //from the comment of botime ..

    /*

    To calculate sell[i]:
    If we sell on the i-th day, the maximum profit is buy[i - 1] + price{buy[i-1] : profit calc by buying previously},
    because we have to buy before we can sell.

    If we cooldown on the i-th day, the maximum profit is same as sell[i - 1] since we did not do anything on the i-th day.
    So sell[i] is the larger one of (buy[i - 1] + price, sell[i - 1])

    To calculate buy[i]:
    If we buy on the i-th day, the maximum profit is sell[i - 2] - price {means curr buy profit should be i-2 sell - curr_price},
    because on the (i-1)th day we can only cooldown.

    If we cooldown on the i-th day, the maximum profit is same as buy[i - 1] since we did not do anything on the i-th day.
    So sell[i] is the larger one of (sell[i - 2] - price, buy[i - 1])

    */

    //so sell[i] : means profit calculated by selling at ith position
    //so buy[i] : means profit calculated by buying at ith position

    private static int maxProfit( int[] prices ) {
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

            buy[i] = Math.max(buy[i - 1], sell[i - 2] - price);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + price);
        }

        // sell[length] >= buy[length] is always greater than buying
        return sell[length];
    }
}