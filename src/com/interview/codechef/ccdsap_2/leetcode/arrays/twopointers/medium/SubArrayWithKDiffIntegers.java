package com.interview.codechef.ccdsap_2.leetcode.arrays.twopointers.medium;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithKDiffIntegers {

    //https://leetcode.com/problems/subarrays-with-k-different-integers/
    public static void main( String[] args ) {
        int[] arr = {1, 2, 1, 2, 3};
        int k = 2;

        System.out.println(subarraysWithKDistinct(arr, k));
    }

    //ref : https://leetcode.com/problems/subarrays-with-k-different-integers/discuss/234482/JavaC%2B%2BPython-Sliding-Window-with-Video
    /*
    Write a helper using sliding window,
    to get the number of subarrays with at most K distinct elements.

    Then f(exactly K) = f(atMost K) - f(atMost K-1).
     */
    private static int subarraysWithKDistinct( int[] A, int K ) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }

    // all subarrays with <= K distinct numbers are counted.
    //Logic is similar to : LongestSubstringAtMost2DistinctChar
    private static int atMostK( int[] A, int K ) {
        int i = 0, j = 0;
        int total = 0;
        int distinct = 0;   // count of distinct numbers in the window.

        Map<Integer, Integer> counter = new HashMap<>();

        while (j < A.length) {

            if (counter.getOrDefault(A[j], 0) == 0) {
                distinct++;
            }

            counter.put(A[j], 1 + counter.getOrDefault(A[j], 0));
            j++;

            while (i < j && distinct > K) {  // shrink the left boundary of window.
                counter.put(A[i], counter.get(A[i]) - 1);

                if (counter.get(A[i]) == 0) {
                    distinct--;
                }

                i++;
            }

            total += j - i;
        }

        return total;
    }
}
