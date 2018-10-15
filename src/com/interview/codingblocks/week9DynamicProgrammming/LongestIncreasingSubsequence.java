package com.interview.codingblocks.week9DynamicProgrammming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main( String args[] ) {
        //int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 80, 6};

        int n = arr.length;

        long startTime = System.nanoTime();

        System.out.println("Length of lis is :"
                + LIS(arr, n));

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Time: " + totalTime);

        long startBottomupDP = System.nanoTime();

        System.out.println(solveBottomUpDp(arr, n));

        long endTimeBottomUP = System.nanoTime();
        long totalTimeBottomUp = endTimeBottomUP - startBottomupDP;
        System.out.println("Time : " + totalTimeBottomUp);
    }

    private static int LIS( int arr[], int n ) {
        int temp, m = 0;

        for (int i = 0; i < n; i++) {

            temp = _lisRecursive(arr, i);

            if (temp > m)
                m = temp;
        }
        return m;
    }

    // https://codereview.stackexchange.com/questions/102232/calculating-longest-increasing-sub-sequence-recursively
    private static int _lisRecursive( int arr[], int n ) {
        if (n == 0) return 1;

        int m = 1;

        for (int i = 0; i < n; i++) {

            //we just need to think for one case, rest recursion will come up with.
            if (arr[i] < arr[n]) {
                int temp = 1 + _lisRecursive(arr, i);

                if (temp > m)
                    m = temp;    //   m = max(m, 1 + _lisRecursive(arr, i));
            }
        }
        return m;
    }

    //https://www.youtube.com/watch?v=vL8QpCpNNiY
    private static int solveBottomUpDp( int[] arr, int n ) {

        int dp[] = new int[arr.length + 1];

        //default length to reach each element is 1.
        Arrays.fill(dp, 1);

        int best = -1;
        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (arr[j] <= arr[i]) {
                    //jth element can be absorbed by ith element
                    int currLen = 1 + dp[j];  //THis recursion is replaced by dp array
                    dp[i] = Math.max(currLen, dp[i]);
                }

                best = Math.max(best, dp[i]); //to find max. of all calculated Longest increasing subsequence
            }
        }

        return best;
    }
}
