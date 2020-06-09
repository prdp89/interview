package com.interview.leetcode.dp.minmaxorununbounded;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {

    //https://leetcode.com/problems/perfect-squares/
    public static void main( String[] args ) {
        System.out.println(numSquares(13));
    }

    //Done by me )
    //Runtime: 120 ms, faster than 25.40% of Java
    private static int numSquares( int n ) {
        //If the given number is a perfect square, return 1
        if (Math.pow(n, 0.5) == (int) Math.pow(n, 0.5)) return 1;

        //if we want all perfect squares from : 1..N
        //perfect sqaures contribute to Min squares sum.
        List<Integer> coins = new ArrayList<>();
        for (int i = 1; i * i <= n; i++)
            coins.add(i * i);

        int[] dp = new int[n + 1];
        dp[0] = 0;

        //same as coin change min coins
        for (int i = 1; i <= n; i++) {

            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.size(); j++) {

                if (coins.get(j) <= i && dp[i - coins.get(j)] != -1)
                    min = Math.min(min, dp[i - coins.get(j)] + 1);
            }

            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }

        return dp[n];
    }
}
