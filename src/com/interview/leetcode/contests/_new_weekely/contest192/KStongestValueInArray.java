package com.interview.leetcode.contests._new_weekely.contest192;

import java.util.Arrays;

public class KStongestValueInArray {

    //https://leetcode.com/contest/weekly-contest-192/problems/the-k-strongest-values-in-an-array/
    public static void main( String[] args ) {
        int[] arr = {6, 7, 11, 7, 6, 8};
        int k = 5;

        System.out.println(Arrays.toString(getStrongest(arr, k)));
    }

    //71 / 71 test cases passed.
    //Runtime: 53 ms
    //Memory Usage: 56.6 MB
    private static int[] getStrongest( int[] arr, int k ) {
        int[] res = new int[k];

        int[] temp = arr.clone();
        Arrays.sort(temp);

        Integer[] integer = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++)
            integer[i] = temp[i];

        int m = temp[(temp.length - 1) / 2];

        Arrays.sort(integer, ( a, b ) -> Math.abs(a - m) - Math.abs(b - m));

        for (int i = 0; i < k; i++) {
            res[i] = integer[integer.length - i - 1];
        }

        return res;
    }
}
