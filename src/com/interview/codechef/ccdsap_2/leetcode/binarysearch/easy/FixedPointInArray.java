package com.interview.codechef.ccdsap_2.leetcode.binarysearch.easy;

public class FixedPointInArray {

    //https://www.geeksforgeeks.org/find-a-fixed-point-in-a-given-array/
    // Fixed Point in an array is an index i such that arr[i] is equal to i
    public static void main( String[] args ) {
        //int[] arr = {-10, -5, 0, 3, 7}; //op= 3

        //int[] arr = {0, 2, 5, 8, 17}; //op= 0

        int[] arr = {-10, -5, 3, 4, 7, 9}; //op = -1

        System.out.println(search(arr, 0, arr.length - 1));
    }

    private static int search( int[] arr, int start, int end ) {

        if (start < end) {

            int mid = (start + end) / 2;

            if (mid == arr[mid])
                return mid;

            //here decision factor is MID, we are moving MID acc. to matched element
            if (mid > arr[mid])
                return search(arr, mid + 1, end);
            else
                return search(arr, start, mid - 1);
        }

        return -1;
    }
}
