package com.interview.codechef.ccdsapfoundation_1.DP.educativeIO;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSumIncreasingSubsequence {

    //i
    public static void main( String[] args ) {
        //System.out.println(MIS(new int[]{1, 101, 2, 3, 100, 4, 5}, 0, 0, 0)); //op : 106 {1,2,3,100}

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            int n = scanner.nextInt();
            int[] arr = new int[n];

            int[] dp = new int[n + 1];

            for (int i = 0; i < n; i++)
                arr[i] = scanner.nextInt();

            Arrays.fill(dp, -1);

            System.out.println(MISDp(arr, 0, 0, Integer.MIN_VALUE, dp));
            // System.out.println(MIS(arr, 0, 0, 0));
        }
    }

    //Max. Increasing Sequence
    private static int MIS( int arr[], int index, int sum, int prevElement ) {

        if (index == arr.length)
            return sum;

        int include = arr[index] > prevElement ? MIS(arr, index + 1, sum + arr[index], arr[index]) : sum;
        int exclude = MIS(arr, index + 1, sum, prevElement);

        return Math.max(include, exclude);
    }

    private static int MISDp( int arr[], int index, int sum, int prevElement, int dp[] ) {

        if (index == arr.length)
            return sum;

        if (dp[index] != -1)
            return dp[index];

        int include = arr[index] > prevElement ? MISDp(arr, index + 1, sum + arr[index], arr[index], dp) : sum;
        int exclude = MISDp(arr, index + 1, sum, prevElement, dp);

        int max = Math.max(include, exclude);
        return dp[index] = max;
    }
}