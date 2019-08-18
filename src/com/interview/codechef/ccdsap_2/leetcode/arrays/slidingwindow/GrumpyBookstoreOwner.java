package com.interview.codechef.ccdsap_2.leetcode.arrays.slidingwindow;

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

        int satisfied = 0;
        int[] window = new int[customers.length];
        int left = 0;
        int right = 0;
        int max = 0;
        int windowSum = 0;

        for (int i = 0; i < customers.length; i++) {

            if (grumpy[i] == 1) {
                //windowsSum : maintains sum of Grumpy customers
                windowSum += customers[i];

                //Window maintain each grumpy customer value
                window[right] = customers[i];
            } else {
                //in-case of satisfied customers that Grumpy window index is Zero
                window[right] = 0;

                //sum calculate all customer that satisfies : when grumpy_owner == 0
                satisfied += customers[i];
            }

            //if we have X number of grumpy customers;
            //Similar to LongestSubstringWithoutRepetChar, slide the window from start; remove left window item.
            if (right >= X) {
                windowSum -= window[left];
                left++;
            }

            //maintain max of X grumpy window customers
            if (windowSum > max) {
                max = windowSum;
            }

            right++;
        }

        //total will be: sum of customer satisfies + Max from grumpy window
        return satisfied + max;
    }
}
