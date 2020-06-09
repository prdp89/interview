package com.interview.leetcode.dp.jumpordistictortotalways;

public class JumpGameV {

    //https://leetcode.com/problems/jump-game-v/
    public static void main( String[] args ) {
        int[] arr = {6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12};
        int d = 2;

        System.out.println(maxJumps(arr, d));
    }

    //Runtime: 9 ms, faster than 90.64% of Java
    //Time : O(N*D)
    private static int maxJumps( int[] arr, int d ) {

        int max = Integer.MIN_VALUE;

        int[] dp = new int[arr.length];

        //Arrays.fill(dp, 1);

        for (int i = 0; i < arr.length; i++)
            max = Math.max(max, dfs(arr, d, i, dp));

        return max;
    }

    private static int dfs( int[] arr, int d, int i, int[] dp ) {
        if (i >= arr.length)
            return 0;

        if (dp[i] != 0) //bcz atleast 1 jump is always present
            return dp[i];

        int res = 1;
        for (int j = i + 1; j <= Math.min(i + d, arr.length - 1) && arr[j] < arr[i]; j++)
            res = Math.max(res, 1 + dfs(arr, d, j, dp));

        for (int j = i - 1; j >= Math.max(i - d, 0) && arr[j] < arr[i]; j--)
            res = Math.max(res, 1 + dfs(arr, d, j, dp));

        return dp[i] = res;
    }
}
