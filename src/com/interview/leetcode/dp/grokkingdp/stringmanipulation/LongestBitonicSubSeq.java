package com.interview.leetcode.dp.grokkingdp.stringmanipulation;

import java.util.Arrays;

public class LongestBitonicSubSeq {

    //http://www.geeksforgeeks.org/dynamic-programming-set-15-longest-bitonic-subsequence/

    //similar problem:
    //https://www.geeksforgeeks.org/maximum-length-bitonic-subarray/
    public static void main( String[] args ) {
        int[] arr = {4, 2, 3, 6, 10, 1, 12};

        System.out.println(longestSequence(arr));
    }

    /*
    Input: {4,2,3,6,10,1,12}
    Output: 5
    Explanation: The LBS is {2,3,6,10,1}.
     */
    private static int longestSequence( int arr[] ) {
        int[] dp = new int[arr.length];

        //this is longest increasing subseq
        //dp[0] = 1;

        Arrays.fill(dp, 1);

        for (int i = 1; i < arr.length; i++) {

            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        //this is longest decreasing subseq.
        int dp2[] = new int[arr.length];

        Arrays.fill(dp2, 1);

        //dp2[arr.length - 1] = 1;

        for (int i = arr.length - 2; i >= 0; i--) {

            for (int j = arr.length - 1; j > i; j--) {
                if (arr[i] > arr[j])
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
            }
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, dp[i] + dp2[i] - 1);
        }

        return max;
    }
}
