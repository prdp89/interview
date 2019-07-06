package com.interview.codechef.ccdsap_2.leetcode.arrays.twopointers;

import java.util.Arrays;

public class DutchNationalFlagProblem {

    //https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
    public static void main( String[] args ) {
        int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        sort012(arr, arr.length);

        System.out.println(Arrays.toString(arr));
    }

    private static void sort012( int a[], int arr_size ) {

        int lo = 0;

        int hi = arr_size - 1;
        int mid = 0, temp;

        while (mid <= hi) {

            //There are three possibilities: a[Mid] is (0) red, (1) white or (2) blue.
            switch (a[mid]) {

                //a[Mid] is red, swap a[Lo] and a[Mid]; Lo++; Mid++
                case 0: {
                    temp = a[lo];
                    a[lo] = a[mid];
                    a[mid] = temp;
                    lo++;
                    mid++;
                    break;
                }

                //Case (1) a[Mid] is white, Mid++
                case 1:
                    mid++;
                    break;

                //Case (2) a[Mid] is blue, swap a[Mid] and a[Hi]; Hi--
                case 2: {
                    temp = a[mid];
                    a[mid] = a[hi];
                    a[hi] = temp;
                    hi--;
                    break;
                }
            }
        }
    }
}
