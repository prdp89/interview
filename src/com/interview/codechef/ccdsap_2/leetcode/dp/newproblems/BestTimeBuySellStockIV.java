package com.interview.codechef.ccdsap_2.leetcode.dp.newproblems;

public class BestTimeBuySellStockIV {

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/#/description

    //just read the description below, recurrence is really easy..
    public static void main( String[] args ) {

        System.out.println(maxProfit(2, new int[]{3, 2, 6, 5, 0, 3})); //op = 7
    }

    //https://www.youtube.com/watch?v=Pw6lrYANjz4
    //input : { 3, 2, 6, 5, 0, 3}
    /*
    1. If we have days= 0 then no way to get profit, so first row will be all zeros
    2. If we have days = {0, 1, 2} but only stock = 3, then also no way to get profit out of it.

    3. if we have day = 1 and stock = {3, 2} we can't get profit
    4. if we have day = 1 and stock = {3, 2, 6} we can get profit = 4 => { 6 - 2 = 4 }

    5. if we have allowed transaction = 2 and stock = {3, 2, 6, 5} we can't do 2 transaction to get max profit so we get profit =4 only
    6. if we have allowed transaction = 2 and stock = {3, 2, 6, 5, 0, 3} we can do 2 transactions to get profit = 7 => { 6 - 2 = 4  and 3 - 0 = 3}

        Stock:-  3   2   6   5   0   3
Days or Trans:
          0      0   0   0   0   0   0

          1      0   0   4   4   4   4

          2      0   0   4   4   0   7
    */

    /* Recurrence relation:

    'j' represent index of stock array.

    Profit[trans][j] = Math.max {

     1. profit[trans][j - 1] : one previous value from 2D table on the same row but prev col

        2. stock[j] +  Math.max {

                                    -stock[x] + profit[trans - 1][x]
                                    where 0 <= x <= j
                                }
                          }
     */

    /*
    to compute profit = 7 on last row of above example :

        here 2 is doing two transaction on last row
        here 5 is computing profit for last stock index = 5

        profit[2][5] = Math.max { profit[2][4] = 0 ,

                                    stock[5] = 3 +

                                    Math.max {
                                            0 <= x <= 5
                                            x= 0 : -3 + profit[1][0] = 0 => -3
                                            x= 1 : -2 + profit[1][1] = 0 => -2
                                            x= 2 : -6 + profit[1][2] = 4 => -2
                                            x= 3 : -5 + profit[1][3] = 4 => -1
                                            x= 4 : -0 + profit[1][4] = 4 => 4
                                            x= 5 : -3 + profit[1][5] = 3 => 0
                                    }
                                }

       profit[2][5] = Math.max { 0, 3 + max{-3,-2,-2,-1,4,0} }
                    = Math.max {0, 3 + 4} => 7
     */


    private static int maxProfit( int k, int[] prices ) {
        int len = prices.length;

        //if number of transactions are greater than the Half size of array.
        if (k >= len / 2)
            return quickSolve(prices);

        int[][] t = new int[k + 1][len];

        for (int i = 1; i <= k; i++) {
            int tmpMax = -prices[0]; //same as adding  -stock[x]

            for (int j = 1; j < len; j++) {

                //this line is equals to: stock[j] +  Math.max {}
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);

                //but instead of calculating max for each profit[i][j] from 0 < j
                //we are maintaining tempMax that reduces complexity to O(N K)
                tmpMax = Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }

        return t[k][len - 1];
    }


    private static int quickSolve( int[] prices ) {
        int len = prices.length, profit = 0;

        for (int i = 1; i < len; i++) {
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        }

        return profit;
    }
}
