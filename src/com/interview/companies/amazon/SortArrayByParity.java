package com.interview.companies.amazon;

import java.util.Arrays;

public class SortArrayByParity {

    //https://leetcode.com/problems/sort-array-by-parity/
    public static void main( String[] args ) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{1, 3, 5})));
        System.out.println(Arrays.toString(sortArrayByParityOPtimal(new int[]{1, 3, 5})));
    }

    // 2 ms, faster than 17.72% of Java
    private static int[] sortArrayByParity( int[] A ) {

        int j = 0, k = 0;

        int temp[] = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0)
                A[j++] = A[i];
            else {
                temp[k++] = A[i];
            }
        }

        k = 0;
        while (j < A.length) {
            A[j++] = temp[k++];
        }

        return A;
    }

    private static int[] sortArrayByParityOPtimal( int[] A ) {

        int j = 0; //this index is handling even nums

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                int temp = A[j];
                A[j++] = A[i];
                A[i] = temp;
            }
        }

        return A;
    }
}
