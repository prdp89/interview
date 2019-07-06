package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestFibonacciSequence {

    //https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
    public static void main( String[] args ) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

        System.out.println(lenLongestFibSubseq(arr));
    }

    private static int lenLongestFibSubseq( int[] A ) {

        if (A == null || A.length == 0)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; ++i)
            map.put(A[i], i);

        int maxLen = 0;

        for (int i = 0; i < A.length; ++i) {

            for (int j = i + 1; j < A.length; ++j) {

                int left = i, right = j, count = 0;

                while (map.containsKey(A[left] + A[right])) {
                    int temp = right;

                    //updating right index of left + right;
                    right = map.get(A[left] + A[right]);

                    left = temp;
                    count++;
                }

                // if exists a sequence, add first 2 nums
                if (count != 0) {

                    count += 2;
                    maxLen = Math.max(maxLen, count);
                }
            }
        }
        return maxLen;
    }

}
