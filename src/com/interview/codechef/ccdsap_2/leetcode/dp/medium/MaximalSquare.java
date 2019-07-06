package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.Arrays;

public class MaximalSquare {

    private static int max = Integer.MIN_VALUE;

    public static void main( String[] args ) {
     /*   char[][] arr = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };*/

        char[][] arr = new char[][]{
                {'0', '0'},
                {'0', '0'}
        };

      /*  char[][] arr = new char[][]{
                {'0', '1'}
        };*/

      /*  char[][] arr = new char[][]{
                {'0', '1'},
                {'1', '0'}
        };*/

        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            System.out.println(0);
            return;
        }

        if (arr.length == 1) {
            if (arr[0].length == 1){
                System.out.println(Character.getNumericValue(arr[0][0]));
                return;
            }
            else {

                int mx = Integer.MIN_VALUE;
                for (int i = 0; i < arr[0].length; i++) {
                    mx = Math.max(mx, Character.getNumericValue(arr[0][i]));
                }

                System.out.println(mx);
                return;
            }
        }

        int dp[][] = new int[arr.length+1][arr[0].length+1];

        for (int d[] : dp) {
            Arrays.fill(d, -1);
        }

        int n = recurse(arr, 0, 0, dp);
        System.out.println(n> 0  ? n * n : atleastOne );
    }

    private static int atleastOne = 0;
    private static int recurse( char[][] arr, int i, int j, int[][] dp ) {

        if (i >= arr.length || j >= arr[0].length) {
            return 0;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        int res;
        if (arr[i][j] == '1') {
            atleastOne = 1;
            res = 1 + Math.min(recurse(arr, i + 1, j + 1, dp), Math.min(recurse(arr, i + 1, j, dp), recurse(arr, i, j + 1, dp)));
        } else
            res = Math.min(recurse(arr, i + 1, j + 1, dp), Math.min(recurse(arr, i + 1, j, dp), recurse(arr, i, j + 1, dp)));

        return dp[i][j] = Math.max(res, max);
    }
}