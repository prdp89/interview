package com.interview.leetcode.nickwhite;

public class LocalAndGloabalInversions {

    //https://leetcode.com/problems/global-and-local-inversions/
    public static void main( String[] args ) {
        int[] a = {1, 0, 2};
        System.out.println(isIdealPermutation(a));
    }

    //Global inversions : [1,2,3,4] exists, if A[0] is greater than any element of A[1]...A[N]
    //Local inversions : [1,2,3,4] exists, if A[0] is greater A[1]
    //That means all Local are inversions are subset of Global Inversions.

    //1st logic: It also means that we can not find A[i] > A[j] when i+2 <= j.

    private static boolean isIdealPermutation( int[] A ) {

        int max = 0;
        for (int i = 0; i < A.length - 2; i++) {
            max = Math.max(max, A[i]);

            //in other words, Global inversions will be greater than local inversions.
            if (max > A[i + 2]) return false;
        }

        return true;
    }

    //2nd logic: Since A will be a permutation of [0, 1, ..., A.length - 1].
    private static boolean isIdealPermutationSecond( int[] A ) {

        for (int i = 0; i < A.length; i++) {
            if (A[i] != i) {
                if (A[i] != i + 1 || A[i + 1] != i)
                    return false;
            }
        }

        return true;
    }
}
