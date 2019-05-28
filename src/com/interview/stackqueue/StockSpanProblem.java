package com.interview.stackqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by saitejatokala on 21/11/15.
 * http://www.geeksforgeeks.org/the-stock-span-problem/
 * Question:
 * The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate span of stock’s price for all n days.
 * The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
 * For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
 * <p>
 * Solution 1:
 * We see that S[i] on day i can be easily computed if we know the closest day preceding i, such that the price is greater than on that day than the price on day i. If such a day exists, let’s call it h(i), otherwise, we define h(i) = -1.
 * The span is now computed as S[i] = i – h(i). See the following diagram.
 */
public class StockSpanProblem {

    //very easy question.....
    /*We have to calculate span values of stack */
    //if arr [] = {100, 60, 70, 65, 80, 85}

    //Span[0] = For 100 no day prior to this: span  = 1
    //Span[1] = For 60, no day prior to it has value less than or equal to it, so span span = 1
    //Span[2] = For 70, a day before has value 60, hence span = 2
    //Span[3] = For 65, there is a day with price 60, but not consecutive, hence, span = 1
    //Span[4] = For 80, there's 65, 70 and 60 which are less, hence span = 4 etc.

    static void calculateSpanBruteForce( int price[] ) {

        int S[] = new int[price.length];
        int n = price.length;

        // Span value of first day is always 1
        S[0] = 1;

        // Calculate span value of remaining days by linearly checking
        // previous days
        for (int i = 1; i < n; i++) {
            S[i] = 1; // Initialize span value

            // Traverse left while the next element on left is smaller
            // than price[i]
            for (int j = i - 1; (j >= 0) && (price[i] >= price[j]); j--)
                S[i]++;
        }
    }

    private static int[] stockSpan( int[] prices ) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] stockSpan = new int[prices.length];

        stockSpan[0] = 1;
        stack.offerFirst(0);
        for (int i = 1; i < prices.length; i++) {

            //stack is maintaining index which are less than current stock
            while (!stack.isEmpty() && prices[stack.peekFirst()] < prices[i]) {
                stack.pollFirst();
            }

            if (stack.isEmpty()) {
                stockSpan[i] = i + 1;
            } else { //decrement the current index from last non-continuous span index.
                //this returns current span bcz stack maintain top incremented value.
                stockSpan[i] = i - stack.peekFirst(); //same logic as MaximumHistogram
            }
            stack.offerFirst(i);
        }
        return stockSpan;
    }

    public static void main( String[] args ) {
        //int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] prices = {100, 60, 70, 65, 80, 85};
        int[] result = stockSpan(prices);
        System.out.print(Arrays.toString(result));
    }
}
