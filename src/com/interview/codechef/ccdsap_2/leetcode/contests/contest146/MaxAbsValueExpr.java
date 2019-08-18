package com.interview.codechef.ccdsap_2.leetcode.contests.contest146;

public class MaxAbsValueExpr {

    //https://leetcode.com/problems/maximum-of-absolute-value-expression/
    public static void main( String[] args ) {
        //int[] arr1 = {1, 2, 3, 4}, arr2 = {-1, 4, 5, 6};
        int[] arr1 = {1, -2, -5, 0, 10}, arr2 = {0, -2, -1, -7, -4};

        System.out.println(solveTry(arr1, arr2));
    }

    private static int solveTry( int[] arr1, int[] arr2 ) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr1.length; i++) {

            for (int j = i + 1; j < arr2.length; j++) {

                int val = Math.abs(arr1[i] - arr1[j]) + Math.abs(arr2[i] - arr2[j]) + Math.abs(i - j);

                max = Math.max(max, val);
            }
        }

        return max;
    }
}
