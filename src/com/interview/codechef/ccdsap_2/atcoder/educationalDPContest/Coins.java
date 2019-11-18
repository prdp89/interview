package com.interview.codechef.ccdsap_2.atcoder.educationalDPContest;

import java.util.Scanner;

public class Coins {

    //Didn't understand this sample properly
    //qut: https://atcoder.jp/contests/dp/tasks/dp_i
    //ref: https://atcoder.jp/contests/dp/submissions/7510523
    static double[][] dp;

    static double calculate( double[] arr, int count, int pos ) {
        if (count == 0)
            return 1;
        if (pos >= arr.length)
            return 0;
        if (dp[count][pos] != -1)
            return dp[count][pos];

        dp[count][pos] = (1 - arr[pos])
                * calculate(arr, count, pos + 1) + (arr[pos]
                * calculate(arr, count - 1, pos + 1));

        return dp[count][pos];
    }

    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int heads = (n / 2);
        double[] arr = new double[n];
        dp = new double[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }

        System.out.println(calculate(arr, heads + 1, 0));
    }
}
