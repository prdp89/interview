package com.interview.leetcode.contests.contest175;

public class SubArraysSizeK {

    /*
    Given an array of integers arr and two integers k and threshold.
    Return the number of sub-arrays of size k and average greater than or equal to threshold.

    Example 1:

    Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
    Output: 3

    Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively. \
    All other sub-arrays of size 3 have averages less than 4 (the threshold).

     */

    //https://leetcode.com/contest/biweekly-contest-19/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
    public static void main( String[] args ) {

        int[] arr = {2, 2, 2, 2, 5, 5, 5, 8};

        int k = 3, threshold = 4;

        System.out.println(solve(arr, k, threshold));
    }

    private static int solve( int[] arr, int k, int threshold ) {

        int count = 0, sum = 0;

        int end = 0, start = -1;

        while (end < arr.length) {

            sum += arr[end];

            if (end - start == k) {

                if (sum >= k * threshold)
                    ++count;

                sum -= arr[++start];
            }

            end++;
        }

        return count;
    }
}
