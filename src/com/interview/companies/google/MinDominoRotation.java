package com.interview.companies.google;

public class MinDominoRotation {

    //https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
    public static void main( String[] args ) {
        System.out.println(minDominoRotations(new int[]{
                3, 5, 1, 2, 3
        }, new int[]{
                3, 6, 3, 3, 4
        }));
    }

    //We find all possible number of rotations to make all the values in A are the same,
    // or all the values in B are the same, and then get the minimum among them.

    /*
    There are 4 possible cases:
    make values in A equal to A[0]
    make values in B equal to A[0]
    make values in A equal to B[0]
    make values in B equal to B[0]

    For each case we count rotations and we get the min rotations among them.
     */

    //Runtime: 3 ms, faster than 98.31% of Java
    private static int minDominoRotations( int[] A, int[] B ) {
        int min = min(swap(A[0], A, B),
                swap(B[0], A, B),
                swap(A[0], B, A),
                swap(B[0], B, A));

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private static int min( int swap, int swap1, int swap2, int swap3 ) {
        return Math.min(swap, Math.min(swap1, Math.min(swap2, swap3)));
    }

    private static int swap( int target, int[] b, int[] a ) {
        int swap = 0;

        for (int i = 0; i < b.length; i++) {
            if (a[i] != target) {

                if (b[i] != target)
                    return Integer.MAX_VALUE;

                swap++;
            }
        }

        return swap;
    }
}
