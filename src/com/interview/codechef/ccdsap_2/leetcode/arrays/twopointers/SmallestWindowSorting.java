package com.interview.codechef.ccdsap_2.leetcode.arrays.twopointers;

//Find smallest window in an array which makes entire array sorted in increasing order.
public class SmallestWindowSorting {

    //https://www.techiedelight.com/smallest-window-sorting-which-make-array-sorted/
    public static void main( String[] args ) {
        int[] A = {1, 3, 2, 7, 5, 6, 4, 8};
        findSubarray(A);

        //System.out.println(Arrays.toString(A));
    }

    private static void findSubarray( int[] A ) {
        int leftIndex = -1, rightIndex = -1;

        // traverse from left to right and keep track of maximum so far
        int max_so_far = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {

            if (max_so_far < A[i]) {
                max_so_far = A[i];
            }

            // find the last position that is less than the maximum so far
            if (A[i] < max_so_far) {
                rightIndex = i;
            }
        }

        // traverse from right to left and keep track of minimum so far
        int min_so_far = Integer.MAX_VALUE;
        for (int i = A.length - 1; i >= 0; i--) {

            if (min_so_far > A[i]) {
                min_so_far = A[i];
            }

            // find the last position that is more than the minimum so far
            if (A[i] > min_so_far) {
                leftIndex = i;
            }
        }

        System.out.print("Sort array from index " + leftIndex
                + " to " + rightIndex);
    }
}
