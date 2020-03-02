package com.interview.codechef.ccdsap_2.leetcode.dp.newproblems;

public class BestTimeBuySellStock {

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    public static void main( String[] args ) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    //ref : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/39062/My-jave-accepted-solution-with-O(N)-time-and-O(1)-space
    private static int maxProfit( int[] prices ) {

        if (prices.length == 0)
            return 0;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            //just storing the min.
            min = Math.min(min, prices[i]);

            //subtracting cur_price - min_price to find max sell profit..
            max = Math.max(max, prices[i] - min);
        }

        return max;
    }
}
