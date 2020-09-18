package com.interview.codechef.ccdsapfoundation_1.DP.educativeIO;

import java.util.Arrays;
import java.util.Scanner;

public class CountSubsetWithSumK {

    /*
    Input : arr[] = {2, 3, 5, 6, 8, 10}
        sum = 10
    op : 3
     */
    //https://www.geeksforgeeks.org/perfect-sum-problem-print-subsets-given-sum/
    //ref: https://stackoverflow.com/questions/22891076/count-number-of-subsets-with-sum-equal-to-k
    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int sum = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        //top down dp
        int[][] dp = new int[n + 1][sum + 1];

        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        System.out.println(countSubsetWithSumEqualsK(arr, dp, sum, 0));
    }

    private static int countSubsetWithSumEqualsK( int[] arr, int[][] dp, int sum, int pos ) {

        if (pos == arr.length && sum == 0) {
            return 1;
        }

        if (pos == arr.length || sum < 0)
            return 0;

        if (dp[pos][sum] != -1)
            return dp[pos][sum];

        int ret1 = countSubsetWithSumEqualsK(arr, dp, sum - arr[pos], pos + 1); //include
        int ret2 = countSubsetWithSumEqualsK(arr, dp, sum, pos + 1); //exclude

        dp[pos][sum] = ret1 + ret2;

        return dp[pos][sum];
    }
}
