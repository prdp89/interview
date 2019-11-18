package com.interview.codechef.ccdsap_2.atcoder.educationalDPContest;

import java.util.Arrays;
import java.util.Scanner;

public class Frog2 {

    private static final int INF = 1000000005;
    private static int[] dp = null;

    //https://atcoder.jp/contests/dp/tasks/dp_b
    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        dp = new int[n + 1];
        Arrays.fill(dp, -1);

       /* int val = solveTopDown(n - 1, arr, k);
        System.out.println(val);*/

        int val1 = solveBottomUp(arr, k);
        System.out.println(val1);
    }

    //time : 498 ms
    private static int solveTopDown( int i, int[] arr, int k ) {
        if (dp[i] != -1) {
            return dp[i];
        }

        if (i == 0) { //if one element left
            dp[i] = 0;
            return dp[i];
        }

        int min = Integer.MAX_VALUE;

        //for each stone frog want to Jump K steps..
        for (int p = k; p >= 1; p--) {

            //if frog can jump at-least one stone..using zero bcz we are using zero based indexing
            if (i - p >= 0) {
                min = Math.min(min, solveTopDown(i - p, arr, k) + Math.abs(arr[i] - arr[i - p]));
            }
        }

        return dp[i] = min;
    }

    //510 ms
    private static int solveBottomUp( int[] arr, int k ) {

        //INF : bcz we are comparing Math.min(dp[j] here..
        Arrays.fill(dp, INF);

        //this indicate to reach first stone cost is zero..
        dp[0] = 0;

        for (int i = 0; i < arr.length; i++) {

            //from each stone : frog can jump to next k stones.
            for (int j = i + 1; j <= i + k; j++) {

                if (j < arr.length) {
                    dp[j] = Math.min(dp[j]
                            , dp[i] + Math.abs(arr[i] - arr[j]));
                }
            }
        }

        return dp[arr.length - 1];
    }
}