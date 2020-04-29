package com.interview.leetcode.nickwhite;

public class SmallestRangeI {

    //https://leetcode.com/problems/smallest-range-i/
    public static void main( String[] args ) {
        int[] A = {1, 3, 6};
        int k = 3;

        System.out.println(smallestRangeI(A, k));
    }

    //Runtime: 2 ms, faster than 76.87% of Java
    private static int smallestRangeI( int[] A, int K ) {

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int aA : A) {
            min = Math.min(min, aA);
            max = Math.max(max, aA);
        }

        //if adding the K turn Min diff. to zero then return zero
        if (min + K >= max - K) {
            return 0;
        } else { //diff. of max - min diff after adding K
            return (max - K) - (min + K);
        }
    }
}
