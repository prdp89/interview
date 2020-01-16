package com.interview.karangujar.dp;

public class IncreasingSubset {

    //based on LongestIncreasingSubSeq : Tutorial - 6
    /*
    P-2:-Given an array of “N” integers, find a sub-sequence(largest-one)
    which is strictly increasing.Also, any 2-consecutive-elements in
    the subset should differ each other only by one(1).

    Input = {2,1,3,0,5,7,8,1,2}
    op = 3 {0, 1, 2}
     */
    public static void main( String[] args ) {
        int[] arr = {2, 1, 3, 0, 5, 7, 8, 1, 2};

        System.out.println(bottomUpDP(arr));
    }

    private static int bottomUpDP( int[] arr ) {

        int[] dp = new int[arr.length];

        dp[0] = 1;

        int i = 1;

        while (i < arr.length) {

            int j = 0;
            int max = 1;

            dp[i] = max;

            while (j <= i - 1) {

                if (arr[i] > arr[j] && arr[i] == arr[j] + 1)
                    dp[i] = max = Math.max(max, 1 + dp[j]);

                j++;
            }

            i++;
        }


        int ans = Integer.MIN_VALUE;
        for (int j = 0; j < dp.length; j++)
            ans = Math.max(ans, dp[j]);

        return ans;
    }
}
