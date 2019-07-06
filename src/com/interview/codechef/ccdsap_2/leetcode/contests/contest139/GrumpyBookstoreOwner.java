package com.interview.codechef.ccdsap_2.leetcode.contests.contest139;

//https://leetcode.com/problems/grumpy-bookstore-owner/
public class GrumpyBookstoreOwner {

    //THis question is an implementation of sliding window technique
    //max of window of size K

    //sliding-window sliding window

    //very easy question
    public static void main( String[] args ) {
        int cust[] = {1, 0, 1, 2, 1, 1, 7, 5};
        int grumpy[] = {0, 1, 0, 1, 0, 1, 0, 1};
        int ownerGrumpyTimesCount = 3;

        System.out.println(maxSatisfied(cust, grumpy, ownerGrumpyTimesCount));
    }

    private static int maxSatisfied( int[] customers, int[] grumpy, int X ) {

        int sum = 0, maxWindow = 0, window = 0;

        for (int i = 0; i < customers.length; ++i) {

            //sum calculate all customer that satisfies : when grumpy_owner == 0
            sum += grumpy[i] == 0 ? customers[i] : 0;

            //calculating a window when owner is grumpy
            window += grumpy[i] == 1 ? customers[i] : 0;

            //similar to Max num in K window problem:
            //removing i-X customer from grumpy window
            if (i >= X)
                window -= grumpy[i - X] == 1 ? customers[i - X] : 0;

            //calculate max at each step
            maxWindow = Math.max(maxWindow, window);
        }
        //total will be: sum of customer satisfies + Max from grumpy window
        return sum + maxWindow;
    }
}
