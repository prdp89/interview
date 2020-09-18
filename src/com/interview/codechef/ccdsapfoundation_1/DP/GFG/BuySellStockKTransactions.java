package com.interview.codechef.ccdsapfoundation_1.DP.GFG;

public class BuySellStockKTransactions {

    //https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-k-times/
    public static void main( String[] args ) {

        int prices[] = {12, 14, 17, 10, 14, 13, 12, 15};
        System.out.println(recurse(prices, 0, 3));
    }

    //watch video for solution motivation : https://www.youtube.com/watch?v=oDhu5uGq_ic
    //http://www.gorecursion.com/algorithm/2016/11/20/2d-dynamic2.html
    private static int recurse( int[] prices, int index, int k ) {

        if (k == 0 || index == prices.length - 1) {
            return 0;
        }

        int profit = 0, min = Integer.MAX_VALUE;

        for (int m = index; m < prices.length; m++) {

            min = Math.min(min, prices[m]);//picking at min prices

            int diff = prices[m] - min;//diff. for current min. picked stock profit

            if (diff > 0) {
                diff += recurse(prices, m + 1, k - 1);
            }
            profit = Math.max(profit, diff);
        }

        return profit;
    }
}
