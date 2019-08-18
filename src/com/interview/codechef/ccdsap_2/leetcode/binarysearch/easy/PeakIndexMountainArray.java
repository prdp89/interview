package com.interview.codechef.ccdsap_2.leetcode.binarysearch.easy;

public class PeakIndexMountainArray {

    //similar to HighestPivotElement

    //https://leetcode.com/problems/peak-index-in-a-mountain-array/
    public static void main( String[] args ) {
        int[] arr = {24, 69, 100, 99, 79, 78, 67, 36, 26, 19};

        //System.out.println(peakIndexInMountainArray_1(arr));
        System.out.println(peakIndexInMountainArray_3(arr));
    }

    private static int peakIndexInMountainArray_1( int[] A ) {
        for (int i = 1; i + 1 < A.length; ++i) {

            //getting ith element is wrongly placed
            if (A[i] > A[i + 1])
                return i;

        }
        return 0;
    }

    //one more variant, it can have multiple maxima's : https://leetcode.com/problems/find-peak-element/submissions/
    private static int peakIndexInMountainArray_2( int[] A ) {
        int l = 0, r = A.length - 1, mid;

        while (l < r) {

            mid = (l + r) / 2;

            //generally in FixedPOintArray : We move in MID + 1 or MID - 1 but in this case we move to mid direction only.
            //bcz MID can also be an answer
            if (A[mid] < A[mid + 1])
                l = mid;
            else if (A[mid - 1] > A[mid])
                r = mid;
            else return mid;
        }
        return 0;
    }

    private static int peakIndexInMountainArray_3( int[] A ) {
        int l = 0, r = A.length - 1, m;

        while (l < r) {

            m = (l + r) / 2;

            //compare this line with brute force above, in this case we are moving left to find better position
            if (A[m] < A[m + 1])
                l = m + 1;
            else
                r = m; //here we got out first peak, at-least right is our answer.
        }

        return r;
    }
}
