package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.Arrays;

public class VideoStitching {

    //https://leetcode.com/problems/video-stitching/
    public static void main( String[] args ) {

        bottomUpDP();
        bottomUpDP_combination_way();
    }

    //This program is classic example of CoinChangeMinCoins
    private static void bottomUpDP() {

        int T = 10;
        int[][] clips = {{0, 2}, {4, 6}, {8, 10}
                , {1, 9}, {1, 5}, {5, 9}};

        // dp[T] - holds the minimum number of clips required to get the T seconds clip length
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

    //Done by me using combination ways as: ZeroOneKnapsack --> com.interview.leetcode.dp.grokkingdp.boundedknapsacktype
    //Runtime: 3 ms, faster than 15.83% of Java
    private static void bottomUpDP_combination_way() {

        int T = 10;
        int[][] clips = {{0, 2}, {4, 6}, {8, 10}
                , {1, 9}, {1, 5}, {5, 9}};

        // dp[T] - holds the minimum number of clips required to get the T seconds clip length
        int[] dp = new int[T + 1];

        Arrays.sort(clips, ( a, b ) -> a[0] - b[0]);

        //Only diff. is we are filling an Array with Total items
        Arrays.fill(dp, T + 1);

        dp[0] = 0;

        for (int i = 0; i < clips.length; i++) {

            for (int j = T; j >= 0; j--) {

                int exclude = dp[j];
                int include = dp[j];

                if (j >= clips[i][0] && j <= clips[i][1])
                    include = dp[clips[i][0]] + 1;

                dp[j] = Math.min(include, exclude);
            }
        }

        System.out.println("comb:" + (dp[T] == T + 1 ? -1 : dp[T]));
    }
}
