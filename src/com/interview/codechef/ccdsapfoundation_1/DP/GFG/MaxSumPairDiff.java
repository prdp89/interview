package com.interview.codechef.ccdsapfoundation_1.DP.GFG;

import java.util.Arrays;

public class MaxSumPairDiff {

    //https://www.geeksforgeeks.org/maximum-sum-pairs-specific-difference/
    public static void main( String[] args ) {

    }

    private static int maxSumPairWithDifferenceLessThanK( int arr[],
                                                          int N, int k ) {
        int maxSum = 0;

        // Sort elements to ensure every i and i-1 is closest
        // possible pair
        Arrays.sort(arr); //sorting to get max pair sum

        // To get maximum possible sum, iterate from largest
        // to smallest, giving larger numbers priority over
        // smaller numbers.

        for (int i = N - 1; i > 0; --i) {

            if (arr[i] - arr[i - 1] < k) {

                //Assuming only positive numbers.
                maxSum += arr[i];
                maxSum += arr[i - 1];

                //When a match is found skip this pair
                --i;
            }
        }

        return maxSum;
    }
}
