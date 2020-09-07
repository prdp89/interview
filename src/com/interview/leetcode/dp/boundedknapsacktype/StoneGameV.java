package com.interview.leetcode.dp.boundedknapsacktype;

import java.util.Arrays;

public class StoneGameV {

    //https://leetcode.com/problems/stone-game-v/
    public static void main( String[] args ) {
        int[] arr = {6, 2, 3, 4, 5, 5};

        System.out.println(stoneGameV(arr));
    }

    private static int stoneGameV( int[] stoneValue ) {
        int[][] dp = new int[501][501];

        for (int[] item : dp)
            Arrays.fill(item, -1);

        return dfs(0, stoneValue.length - 1, stoneValue, dp);
    }

    //Runtime: 73 ms, faster than 67.13% of Java
    private static int dfs( int start, int end, int[] stoneValue, int[][] dp ) {
        if (start > end)
            return 0;

        if (dp[start][end] != -1)
            return dp[start][end];

        //calculating sum of items of an Array
        int r = 0;
        for (int i = start; i <= end; i++) {
            r += stoneValue[i];
        }

        int l = 0;
        int ans = 0;

        //we are dividing the Array into Subset{continuous array elements partition}
        for (int i = start; i <= end; i++) {
            l += stoneValue[i];
            r -= stoneValue[i]; //right will be subtract of whatever the left part taken..

            //Alice score will be smaller left part + next item in recursion
            if (l < r) {
                ans = Math.max(ans, l + dfs(start, i, stoneValue, dp));
            } else if (l == r) { //if both group is same; Optimal pickup will be Max(leftPart, rightPart)
                ans = Math.max(ans,
                        l + Math.max(dfs(start, i, stoneValue, dp)
                                , dfs(i + 1, end, stoneValue, dp)));
            } else if (r < l) { //picking right part for recursion
                ans = Math.max(ans, r + dfs(i + 1, end, stoneValue, dp));
            }
        }

        return dp[start][end] = ans;
    }
}
