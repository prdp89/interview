package com.interview.codechef.ccdsap_2.atcoder.educationalDPContest;

import java.util.Scanner;

public class Knapsack1 {

    private static long[][] dp;
    private static int[] w;
    private static int[] v;

    public static void main( String[] args ) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w1 = sc.nextInt();

        dp = new long[n + 1][w1 + 1];
        w = new int[n + 1];
        v = new int[n + 1];

        w[0] = 0;
        v[0] = 0;

        for (int i = 1; i <= n; i++) {
            w[i] = Integer.parseInt(sc.next());
            v[i] = Integer.parseInt(sc.next());
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w1; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(nap(n, w1));
        sc.close();
    }

    private static long nap( int i, int j ) {
        if (dp[i][j] >= 0)
            return dp[i][j];

        long rem;

        if (i == 0) {
            rem = 0;
        }
        //if weight of item is more than remainingWeight then try next item by skipping current item
        else if (j < w[i]) {
            rem = nap(i - 1, j);
        } else {  //try to get maximumValue of either by picking the currentItem or not picking currentItem
            rem = Math.max(nap(i - 1, j - w[i]) + v[i], nap(i - 1, j));
        }

        dp[i][j] = rem;

        return rem;
    }
}