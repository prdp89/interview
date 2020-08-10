package com.interview.leetcode.dp.minmaxorununbounded;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {

    //https://leetcode.com/problems/perfect-squares/
    public static void main( String[] args ) {
        System.out.println(numSquares(13));

        System.out.println(numSquares_Comb_way(13));
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

    //done by me :) Runtime: 164 ms, faster than 19.46% of Java online
    private static int numSquares_Comb_way( int n ) {
        //If the given number is a perfect square, return 1
        if (Math.pow(n, 0.5) == (int) Math.pow(n, 0.5)) return 1;

        //if we want all perfect squares from : 1..N
        //perfect sqaures contribute to Min squares sum.
        List<Integer> coins = new ArrayList<>();
        for (int i = 1; i * i <= n; i++)
            coins.add(i * i);

        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 0; i < coins.size(); i++) {

            for (int t = coins.get(i); t <= n; t++) {
                int include = Integer.MAX_VALUE, exclude = Integer.MAX_VALUE;

                if (i > 0)
                    exclude = dp[t]; //exclude the coin

                if (t >= coins.get(i)) {
                    if (dp[t - coins.get(i)] != Integer.MAX_VALUE)
                        include = 1 + dp[t - coins.get(i)]; // include the coin
                }

                dp[t] = Math.min(exclude, include);
            }
        }

        return (dp[n] == Integer.MAX_VALUE ? -1 : dp[n]);
    }
}
