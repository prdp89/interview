package com.interview.codechef.ccdsapfoundation_1.sorting;

import java.util.Arrays;

public class SortArrayByParityII {

    //https://leetcode.com/problems/sort-array-by-parity-ii
    public static void main( String[] args ) {
        //  System.out.println(Arrays.toString(sortArrayByParityII(new int[]{4, 2, 5, 7})));

        System.out.println(Arrays.toString(sortArrayByParityInPlaceII(new int[]{4, 2, 5, 7})));
    }

    private static int[] sortArrayByParityII( int[] A ) {
        int[] res = new int[A.length];
        int j = 0, k = 1;

        for (int aA : A) {

            if (aA % 2 == 0) {
                res[j] = aA;
                j += 2;
            } else {
                res[k] = aA;
                k += 2;
            }
        }

        return res;
    }

    //in place solution
    private static int[] sortArrayByParityInPlaceII( int[] A ) {
        int e = 0;
        int o = 1;

        while (e < A.length && o < A.length) {
            if (A[e] % 2 != 0) {
                swap(A, e, o);
                o += 2;
            } else {
                e += 2;
            }
        }

        return A;
    }

    private static void swap( int[] a, int e, int o ) {
        int t = a[e];
        a[e] = a[o];
        a[o] = t;
    }
}
