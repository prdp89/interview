package com.interview.codechef.ccdsap_2.leetcode.dp.newproblems;

public class BestTimeBuySellStockIII {

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
    public static void main( String[] args ) {

        System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4})); //op = 6
    }

    //this solution is similar to BestTimeBuySellStock , just added extra one state of buying again..
    private static int maxProfit( int[] prices ) {

        int oneBuy = Integer.MAX_VALUE;
        int twoBuy = Integer.MAX_VALUE;

        int oneBuyOneSell = 0; //profit for buying first time
        int twoBuyTwoSell = 0; //profit for buying first time

        for (int i = 0; i < prices.length; i++) {
            int curPrice = prices[i];

            //Buying and selling first time..
            oneBuy = Math.min(oneBuy, curPrice);
            oneBuyOneSell = Math.max(oneBuyOneSell, curPrice - oneBuy);

            //Buying and selling second time..
            //When we buy second time then second buy cost will be : cur_stock_price - prev_profit.
            //This will also ensure the total profit on second time buy-> sell stock..

            twoBuy = Math.min(twoBuy, curPrice - oneBuyOneSell);
            twoBuyTwoSell = Math.max(twoBuy, curPrice - twoBuy);
        }

        return twoBuyTwoSell;
    }
}
