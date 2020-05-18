package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.Arrays;

public class VideoStitching {

    //https://leetcode.com/problems/video-stitching/
    public static void main( String[] args ) {

        bottomUpDP();
    }

    //This program is classic example of CoinChangeMinCoins
    private static void bottomUpDP() {

        int T = 10;
        int[][] clips = {{0, 2}, {4, 6}, {8, 10}
                , {1, 9}, {1, 5}, {5, 9}};

        int[] dp = new int[T + 1];

        //Only diff. is we are filling an Array with Total items
        Arrays.fill(dp, T + 1);

        dp[0] = 0;

        for (int i = 1; i <= T; i++) {

            for (int[] c : clips) {

                if (i >= c[0] && i <= c[1])
                    dp[i] = Math.min(dp[i], dp[c[0]] + 1);
            }
        }

        System.out.println(dp[T] == T + 1 ? -1 : dp[T]);
    }
}
