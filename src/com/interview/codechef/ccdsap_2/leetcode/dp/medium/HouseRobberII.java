package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.Arrays;

public class HouseRobberII {

    //https://leetcode.com/problems/house-robber-ii/
    public static void main( String[] args ) {

        int[] arr = {1, 2, 3, 1};

        int[] dp = new int[arr.length];

        Arrays.fill(dp, -1);

        int val1 = recurse(arr, 0, arr.length - 2, dp);

        Arrays.fill(dp, -1);

        int val2 = recurse(arr, 1, arr.length - 1, dp);

        System.out.println(Math.max(val1, val2));
    }

    //passing all test cases :) //https://leetcode.com/submissions/detail/232828974/
    private static int recurse( int[] arr, int i, int length, int[] dp ) {

        if (length == i)
            return arr[i];

        if (i > length)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        return dp[i] = Math.max(arr[i] + recurse(arr, i + 2, length, dp)
                , recurse(arr, i + 1, length, dp));
    }
}
