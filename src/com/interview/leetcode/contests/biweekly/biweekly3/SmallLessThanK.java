package com.interview.leetcode.contests.biweekly.biweekly3;

public class SmallLessThanK {

    public static void main( String[] args ) {
       /* int[] arr = {34, 23, 1, 24, 75, 33, 54, 8};
        int k = 60;*/

        int[] arr = {10, 20, 30};
        int k = 15;


        System.out.println(solve(arr, k));
    }

    private static int solve( int[] arr, int k ) {

        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] + arr[j] < k) {
                    max = Math.max(max, arr[i] + arr[j]);
                }
            }
        }

        return max;
    }
}
