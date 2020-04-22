package com.interview.leetcode.contests.contest177;

public class CountNiceSubArrays {

    //https://leetcode.com/problems/count-number-of-nice-subarrays/
    public static void main( String[] args ) {

        int k = 1, A[] = {2, 4, 6};
        System.out.println(atMost(A, k) - atMost(A, k - 1));
    }

    //similar logic as SubArrayWithKDiffIntegers
    //Exactly K times = at most K times - at most K - 1 times
    private static int atMost( int[] A, int k ) {
        int res = 0, i = 0, n = A.length, temp = 0;

        for (int j = 0; j < n; j++) {

            temp += A[j] % 2;

            while (temp > k)
                temp -= A[i++] % 2;

            res += j - i + 1;
        }
        return res;
    }
}
