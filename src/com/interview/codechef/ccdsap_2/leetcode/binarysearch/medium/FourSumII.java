package com.interview.codechef.ccdsap_2.leetcode.binarysearch.medium;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/4sum-ii/

//Another variant of com.interview.array.FourSum
public class FourSumII {

    public static void main( String[] args ) {

        int[] a = {1, 2};
        int[] b = {-2, -1};
        int[] c = {-1, 2};
        int[] d = {0, 2};

        System.out.println(fourSumCount(a, b, c, d));
    }

    private static int fourSumCount( int[] A, int[] B, int[] C, int[] D ) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int aC : C) {

            for (int aD : D) {

                int sum = aC + aD;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        //if A+b = 1 now we have find -(c+d)
        int res = 0;
        for (int aA : A) {

            for (int aB : B) {

                res += map.getOrDefault(-1 * (aA + aB), 0);
            }
        }

        return res;
    }
}
