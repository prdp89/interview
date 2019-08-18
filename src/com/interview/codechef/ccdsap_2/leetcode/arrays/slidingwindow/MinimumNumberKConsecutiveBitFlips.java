package com.interview.codechef.ccdsap_2.leetcode.arrays.slidingwindow;

public class MinimumNumberKConsecutiveBitFlips {

    //https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/
    public static void main( String[] args ) {
        int[] arr = {0, 0, 0, 1, 0, 1, 1, 0};
        int k = 3;

        System.out.println(minKBitFlips(arr, k));
    }

    private static void flip( int[] A, int K, int i ) {

        //from current i index to K bit to be flipped
        for (int j = i; j < i + K; j++) {

            A[j] = 1 - A[j];

            //is faster
            //A[j] ^= 1;
        }
    }

    //The time complexity of this solution is O(n * K), where n is the length of A
    private static int minKBitFlips( int[] A, int K ) {
        int cnt = 0;

        for (int i = 0; i < A.length; i++) {

            if (A[i] == 0) {

                //if current index + bit_flip greater than arr length then not possible.
                if (i + K > A.length)
                    return -1;

                //flip each zero element.
                flip(A, K, i);

                cnt++;
            }
        }
        return cnt;
    }
}
