package com.interview.codechef.ccdsap_2.leetcode.dp.easy;

import java.util.Arrays;

public class MinCostClimbingStairs {

    //https://leetcode.com/problems/min-cost-climbing-stairs
    public static void main( String[] args ) {

        //int[] arr = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] arr = new int[]{10, 15, 20};
        int[] dp = new int[arr.length];

        Arrays.fill(dp, -1);

        int call_1 = minWays(arr, arr.length - 1, dp);

        Arrays.fill(dp, -1);
        int call_2 = minWays(arr, arr.length - 2, dp);

        System.out.println(Math.min(call_1, call_2));
    }

    private static int minWays( int[] arr, int index, int[] dp ) {

        if (index == 0)
            return arr[index];

        if (index < 0)
            return 0;

        if (dp[index] != -1)
            return dp[index];

        int cost1 = arr[index] + minWays(arr, index - 1, dp);
        int cost2 = arr[index] + minWays(arr, index - 2, dp);

        return dp[index] = Math.min(cost1, cost2);
    }

    //Bottom-UP Dp solution
    //ref: https://leetcode.com/problems/min-cost-climbing-stairs/discuss/144682/3-Lines-Java-Solution-O(1)-space
    public int minCostClimbingStairs( int[] cost ) {

        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }

        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
}
