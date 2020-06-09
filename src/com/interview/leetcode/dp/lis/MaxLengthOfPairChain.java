package com.interview.leetcode.dp.lis;

import java.util.Arrays;

public class MaxLengthOfPairChain {

    //https://leetcode.com/problems/maximum-length-of-pair-chain/
    public static void main( String[] args ) {
        int[][] arr = {
                {1, 2},
                {2, 3},
                {3, 4}
        };

        System.out.println(findLongestChain(arr));
    }

    //Completely solved by me :D
    //Runtime: 40 ms, faster than 31.92% of Java
    private static int findLongestChain( int[][] pairs ) {

        if (pairs.length == 0)
            return 0;

        int[] dp = new int[pairs.length];

        Arrays.sort(pairs, ( a, b ) -> {
            return a[0] - b[0];
        });

        int max = 1;
        for (int i = 0; i < pairs.length; i++) {

            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
