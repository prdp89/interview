package com.interview.leetcode.contests._new_weekely.weekely204;

public class PatternMRepeatKTimes {

    //https://leetcode.com/contest/weekly-contest-204/problems/detect-pattern-of-length-m-repeated-k-or-more-times/
    public static void main( String[] args ) {
        int[] arr = {1, 2, 1, 2, 1, 1, 1, 3};
        int m = 2, k = 2;

        System.out.println(containsPattern(arr, m, k));
    }

    //Runtime: 0 ms, faster than 100.00% of Java
    private static boolean containsPattern( int[] arr, int m, int k ) {

        int count = 0;
        for (int i = 0; i < arr.length - m; i++) {

            if (arr[i] == arr[i + m]) {
                count++;
            } else {
                count = 0;
            }

            if (count == m * (k - 1)) //if matches all the K's number of pattern
                return true;
        }
        return false;
    }
}
