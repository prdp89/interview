package com.interview.codechef.ccdsap_2.atcoder.educationalDPContest;

import java.util.Arrays;
import java.util.Scanner;

public class Vacation {

    //https://atcoder.jp/contests/dp/tasks/dp_c
    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
            arr[i][2] = scanner.nextInt();
        }

       /* int[] dp = new int[3];

        Arrays.fill(dp, -1);
        int val = dfs(arr, 1, dp);

        System.out.println(val);*/

        int[][] dp = new int[n][3];
        for (int[] ay : dp)
            Arrays.fill(ay, -1);

       /* int ans = Math.max(solveTopDown(0, 0, arr, dp)
                , Math.max(solveTopDown(0, 1, arr, dp)
                        , solveTopDown(0, 2, arr, dp)));

        System.out.println(ans);*/

        for (int[] ay : dp)
            Arrays.fill(ay, -1);

        solveBottomUp(arr, dp);
    }

    //ref: https://atcoder.jp/contests/dp/submissions/7447089

    //Time : 650 ms
    private static int solveTopDown( int row, int curSelection, int[][] arr, int[][] dp ) {
        if (row >= arr.length)
            return 0;

        if (dp[row][curSelection] == -1) {

            int max = Integer.MIN_VALUE;

            //At each day Taro can do 3 activities...
            for (int j = 0; j < 3; j++) {

                //Next day activity should be different from Cur-selected Activity
                //For eg: during first function call we did : solveTopDown(0, 0, arr, dp)
                //here curSelection=0, so Taro can only choose from {1,2} activities to gain Max happiness.
                if (curSelection != j) {

                    int choice = solveTopDown(row + 1, j, arr, dp) + arr[row][j];

                    if (max < choice)
                        max = choice;
                }
            }

            dp[row][curSelection] = max;
        }

        return dp[row][curSelection];
    }

    //ref : https://atcoder.jp/contests/dp/submissions/7615295
    //Time : 629 ms
    private static void solveBottomUp( int[][] arr, int[][] dp ) {
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for (int i = 1; i < arr.length; i++) {

            //At each day Taro can do 3 activities...
            for (int j = 0; j < 3; j++) {

                //Next day activity should be different from Cur-selected Activity
                if (j == 0) {
                    dp[i][0] = Math.max(dp[i - 1][1] + arr[i][0], dp[i - 1][2] + arr[i][0]);
                } else if (j == 1) {
                    dp[i][1] = Math.max(dp[i - 1][2] + arr[i][1], dp[i - 1][0] + arr[i][1]);
                } else {
                    dp[i][2] = Math.max(dp[i - 1][1] + arr[i][2], dp[i - 1][0] + arr[i][2]);
                }
            }
        }

        System.out.println(Math.max(dp[arr.length - 1][2], Math.max(dp[arr.length - 1][0], dp[arr.length - 1][1])));
    }

    private static int dfs( int[][] arr, int index, int[] dp ) {

        if (arr.length - 1 == index) {
            return Math.max(dp[2], Math.max(dp[0], dp[1]));
            //return Math.max(arr[index - 1][2], Math.max(arr[index - 1][0], arr[index - 1][1]));
        }

        dp[0] = Math.max(arr[index][0] + arr[index - 1][1], arr[index][0] + arr[index - 1][2]) + dfs(arr, index + 1, dp);
        dp[1] = Math.max(arr[index][1] + arr[index - 1][2], arr[index][1] + arr[index - 1][0]) + dfs(arr, index + 1, dp);
        dp[2] = Math.max(arr[index][2] + arr[index - 1][1], arr[index][2] + arr[index - 1][0]) + dfs(arr, index + 1, dp);

        return Math.max(dp[0], Math.max(dp[1], dp[2]));
    }
}
