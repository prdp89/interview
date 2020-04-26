package com.interview.leetcode.nickwhite;

public class MonotonicArray {

    //https://leetcode.com/problems/monotonic-array/
    public static void main( String[] args ) {
        int[] arr = {6, 5, 4, 4};

        System.out.println(isMonotonicOptimal(arr));
    }

    //Runtime: 2 ms, faster than 22.85% of Java
    private static boolean isMonotonic( int[] A ) {
        if (A.length == 0 || A.length < 2)
            return true;

        boolean increasing = false;
        if (A[0] < A[1])
            increasing = true;

        for (int i = 1; i < A.length; i++)
            if (A[i - 1] != A[i] && A[i - 1] < A[i])
                increasing = true;
            else if (A[i - 1] != A[i] && A[i - 1] > A[i])
                increasing = false;

        for (int i = 1; i < A.length; i++) {

            if (increasing && A[i] < A[i - 1])
                return false;

            if (!increasing && A[i] > A[i - 1])
                return false;
        }

        return true;
    }

    //Runtime: 1 ms, faster than 100.00% of Java
    private static boolean isMonotonicOptimal( int[] A ) {
        boolean inc = false, decr = false;

        for (int i = 1; i < A.length; i++) {

            if (A[i] < A[i - 1])
                decr = true;
            else if (A[i] > A[i - 1])
                inc = true;
        }

        return !inc || !decr;
    }
}
