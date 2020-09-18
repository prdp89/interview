package com.interview.codechef.ccdsapfoundation_1.DP.educativeIO;

import java.util.Arrays;

public class BadNeighbours {

    //problem: https://community.topcoder.com/stat?c=problem_statement&pm=2402&rd=5009
    //inspiration: https://discuss.codechef.com/t/topcoder-bad-neighbour-dp-based-problem/13640/2
    //Ref: https://www.topcoder.com/tc?module=Static&d1=match_editorials&d2=tccc04_online_rd_4
    public static void main( String[] args ) {

        //int[] arr = new int[]{10, 3, 2, 5, 7, 8}; //The maximum donation is 19, achieved by 10+2+7.

        int[] arr = new int[]{7, 7, 7, 7, 7, 7, 7}; //op 21

        System.out.println(badNeighbours(arr, arr.length));

        //System.out.println(solveBottomupDP(arr, arr.length));
    }

    //working solution, pass test cases
    private static int solveBottomupDP( int[] donations, int N ) {
        int[] dp = new int[50];

          /*
            There are two main cases to be considered here.
            1. Include element at index 0.
                - This leads us to not pick the last element since it is cyclic in nature.
            2. Include element at index 1.
                - In this case, we can pick the last element.
            but whether we pick the element at i, depends on the following condition:
                dp[i] = max(dp[i-2] + donations[i], dp[i-1])
            which basically states, is it in our interest to pick the current donation and
            drop the donation offered by the previous neighbor.
            We pick the max of both cases stated earlier.
          */

        dp[0] = donations[0];

        for (int i = 2; i < N - 1; ++i) {
            dp[i] = Math.max(dp[i - 2] + donations[i], dp[i - 1]);
        }

        int ans1 = dp[N - 2];

        Arrays.fill(dp, 0);
        dp[1] = donations[1];

        for (int i = 2; i < N; ++i) {
            dp[i] = Math.max(dp[i - 2] + donations[i], dp[i - 1]);
        }

        int ans2 = dp[N - 1];

        return Math.max(ans1, ans2);
    }

    //not returning correct answer
    private static int badNeighbours( int arr2[], int n ) {

        int m = 0;

        int[] arr = new int[]{3, 2, 5, 7, 8};
        int[] arr1 = new int[]{10, 3, 2, 5, 7, 8};

        // m = _badNeighbours(arr, 2);
        n = _badNeighbours(arr1, 5);

        return Math.max(m, n);
    }

    private static int _badNeighbours( int[] arr, int ij ) {

        if (ij <= 0)
            return arr[0];

        if (ij == 1)
            return Math.max(arr[ij], arr[ij - 1]);

        if (ij == 2)
            return Math.max(_badNeighbours(arr, ij - 1), arr[ij] + _badNeighbours(arr, 0));

        /*if (ij >= arr.length)
            return arr[arr.length - 1];*/

        int m = 0;

        // for (int i = ij; i < arr.length - 1; i++) {

        int x = arr[ij] + _badNeighbours(arr, ij - 2);
        int y = arr[ij - 1] + _badNeighbours(arr, ij - 3);

        m = Math.max(x, y);
        //}
        return m;
    }
}
