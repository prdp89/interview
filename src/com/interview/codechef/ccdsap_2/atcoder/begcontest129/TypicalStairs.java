package com.interview.codechef.ccdsap_2.atcoder.begcontest129;

import java.util.Arrays;
import java.util.Scanner;

public class TypicalStairs {

    //https://atcoder.jp/contests/abc129/tasks/abc129_c
    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);

        int stairs = scanner.nextInt(), broken = scanner.nextInt();

        boolean[] visit = new boolean[stairs + 1];

        long[] dp = new long[stairs + 1];

        Arrays.fill(dp, -1);

        while (broken-- > 0) {
            int num = scanner.nextInt();
            visit[num] = true;
        }

        System.out.println(recurse(stairs, visit, dp));
    }

    //recursion working fine but DP returns wrong result..
    private static long recurse( int stairs, boolean[] visit, long[] dp ) {

        if (stairs == 0 || stairs == 1)
            return 1;

        if (dp[stairs] != -1)
            return dp[stairs];

        if (!visit[stairs]) {
            long MOD = (long) 1e9 + 7;
            return dp[stairs] = ((recurse(stairs - 1, visit, dp))  + (recurse(stairs - 2, visit, dp))  ) % MOD;
        }

        return 0;
    }
}