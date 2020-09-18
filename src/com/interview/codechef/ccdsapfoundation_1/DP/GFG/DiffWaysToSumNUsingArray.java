package com.interview.codechef.ccdsapfoundation_1.DP.GFG;

public class DiffWaysToSumNUsingArray {

    //https://www.geeksforgeeks.org/ways-sum-n-using-array-elements-repetition-allowed/
    public static void main( String[] args ) {

        int[] arr = new int[]{12, 3, 1, 9};
        int N = 14;

        System.out.println(recurseUtil(arr, N));
    }

    //not returning correct result
    private static int recurseUtil( int[] arr, int sum ) {

        int ways = 0;
        for (int i = 1; i <= sum; i++) {

            ways += recurse(arr, sum, i, 0);
        }

        return ways;
    }

    private static int recurse( int[] arr, int sum, int index, int remaining ) {

        if (index < arr.length && remaining == sum)
            return 1;

        if (index >= arr.length || remaining > sum)
            return 0;

        for (int i = 0; i < arr.length; i++) {

            return 1 + recurse(arr, sum, i + 1, remaining + arr[i + 1]);
        }

        return 0;
    }

    //this prgram is similar to coin change problem; except we recurse on arr;
    //in coin change we recurse on total money...

    /*private static int recurse( int[] arr, int sum, int index, int remaining ) {

        if (index < arr.length && remaining == sum)
            return 1;

        if (index >= arr.length || remaining > sum)
            return 0;

        for (int i = 1; i < arr.length; i++) {
            return 1 + recurse(arr, sum, i, remaining + arr[i]);
        }

        return 0;
    }*/

}
