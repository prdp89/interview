package com.interview.leetcode.contests.biweekly.biweekely34;

import java.util.Arrays;

public class CountAllRoutes {

    //https://leetcode.com/problems/count-all-possible-routes/
    public static void main( String[] args ) {
        int[] locations = {2, 3, 6, 8, 4};
        int start = 1, finish = 3, fuel = 5;

        System.out.println(countRoutes(locations, start, finish, fuel));
    }

    //Runtime: 126 ms, faster than 43.72% of Java
    private static int countRoutes( int[] locations, int start, int finish, int fuel ) {
        int n = locations.length;
        long[][] dp = new long[n][fuel + 1];

        for (long[] item : dp)
            Arrays.fill(item, -1);

        return (int) solve(locations, start, finish, dp, fuel);
    }

    private static long solve( int[] locations, int currCity, int finishCity, long[][] dp, int fuel ) {
        //if no fuel left
        if (fuel < 0)
            return 0;

        //if already calculated
        if (dp[currCity][fuel] != -1)
            return dp[currCity][fuel];

        long ans = currCity == finishCity ? 1 : 0;

        for (int nextCity = 0; nextCity < locations.length; nextCity++) {

            if (nextCity != currCity) {

                //we are not incrementing nextCity; So this is UnboundedType
                ans += solve(locations, nextCity, finishCity, dp
                        , fuel - Math.abs(locations[currCity] - locations[nextCity]));

                ans %= 1000000007;
            }
        }

        return dp[currCity][fuel] = ans;
    }
}
