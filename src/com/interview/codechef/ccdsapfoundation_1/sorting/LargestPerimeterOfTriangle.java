package com.interview.codechef.ccdsapfoundation_1.sorting;

import java.util.Arrays;

public class LargestPerimeterOfTriangle {

    public static void main( String[] args ) {

    }

    //https://www.geeksforgeeks.org/maximum-perimeter-triangle-from-array/
    //https://leetcode.com/problems/largest-perimeter-triangle/
    public int largestPerimeter( int[] A ) {

        Arrays.sort(A);

        for (int i = A.length - 1; i > 1; --i)
            if (A[i] < A[i - 1] + A[i - 2])
                return A[i] + A[i - 1] + A[i - 2];

        return 0;
    }
}
