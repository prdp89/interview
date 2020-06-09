package com.interview.leetcode.dp.jumpordistictortotalways;

import java.util.Arrays;

public class StoneGameIII {

    //https://leetcode.com/problems/stone-game-iii/
    //https://www.youtube.com/watch?v=HsY3jFyaePU&feature=youtu.be&list=PLKZaSt2df1gxtem7J8QqY8m2bHliz8mPt&t=1
    public static void main( String[] args ) {
        int[] arr = {1, 2, 3, 6};

        System.out.println(stoneGameIII(arr));

        System.out.println(stoneGameIII_BottomUP_DP(arr));
    }

    //Runtime: 44 ms, faster than 42.70% of Java
    private static String stoneGameIII( int[] stoneValue ) {

        int[] dp = new int[stoneValue.length];
        Arrays.fill(dp, Integer.MAX_VALUE);

        int aliceScore = dfs(0, stoneValue, dp);

        if (aliceScore > 0)
            return "Alice";
        else if (aliceScore < 0)
            return "Bob";
        else return "Tie";
    }

    private static int dfs( int i, int[] stoneValue, int[] dp ) {
        if (i >= stoneValue.length)
            return 0;

        int ans = Integer.MIN_VALUE;

        if (dp[i] == Integer.MAX_VALUE) {
            ans = Math.max(ans, stoneValue[i] - dfs(i + 1, stoneValue, dp)); //choose 1 stone, give others to Bob

            if (i + 1 < stoneValue.length)
                ans = Math.max(ans, stoneValue[i] + stoneValue[i + 1] - dfs(i + 2, stoneValue, dp)); //choose 2 stone, give others to Bob

            if (i + 2 < stoneValue.length)
                ans = Math.max(ans, stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dfs(i + 3, stoneValue, dp)); //choose 3 stone, give others to Bob

            dp[i] = ans;
        }

        return dp[i];
    }

    //Runtime: 5 ms, faster than 96.89% of Java
    private static String stoneGameIII_BottomUP_DP( int[] stoneValue ) {
        //+1 ;due to zero based indexing
        int[] dp = new int[stoneValue.length + 1];

        //Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = stoneValue.length - 1; i >= 0; i--) {
            int ans = Integer.MIN_VALUE;

            ans = Math.max(ans, stoneValue[i] - dp[i + 1]);

            if (i + 1 < stoneValue.length)
                ans = Math.max(ans, stoneValue[i] + stoneValue[i + 1] - dp[i + 2]);

            if (i + 2 < stoneValue.length)
                ans = Math.max(ans, stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp[i + 3]);

            dp[i] = ans;
        }

        if (dp[0] > 0)
            return "Alice";
        else if (dp[0] < 0)
            return "Bob";
        else return "Tie";
    }
}
