package com.interview.codingblocks.week9DynamicProgrammming;

import java.util.Arrays;
import java.util.Scanner;

public class Mixtures {

    //private final static long MOD = 1000000000; //taken bcz result be very large
    static int[] arr;
    private static long[][] dp = new long[1000][1000];

    //https://www.spoj.com/problems/MIXTURES/
    //https://www.youtube.com/watch?v=XHjjIJxnAJY
    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {

            int n = scanner.nextInt();

            arr = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = scanner.nextInt();

            // Fill each row with -1
            for (long[] row : dp)
                Arrays.fill(row, -1);

            System.out.println(solveTopDownDP(0, n - 1));

            // System.out.println(Arrays.toString(arr));
        }
    }

    private static long solveTopDownDP( int i, int j ) {

        if (i >= j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        //Now break the expression for every possible K
        //or K is partition point for series 0...N

        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {

            //Suppose series is:
            // A1..A2..Ak..................Ak+1..Ak+2..An
            //Step1:  // f(i, k) ........+............ f(k+1, j)

            //Step2:  // sum of A[i],i=1..k ......*...... sum of A[j], j= k+1..n

            //step1: solveTopDownDP(i, k) + solveTopDownDP(k+1, j)
            //Step2 :

            dp[i][j] = Math.min(dp[i][j], solveTopDownDP(i, k) + solveTopDownDP(k + 1, j) +
                    sumOfNum(i, k) * sumOfNum(k + 1, j));
        }

        return dp[i][j];
    }

    private static long sumOfNum( int start, int end ) {
        long sum = 0;

        for (int i = start; i <= end; i++) {
            sum += arr[i];
            sum %= 100;
        }

        return sum;
    }
}