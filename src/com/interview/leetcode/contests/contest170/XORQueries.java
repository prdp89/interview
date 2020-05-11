package com.interview.leetcode.contests.contest170;

import java.util.Arrays;

public class XORQueries {

    //https://leetcode.com/contest/weekly-contest-170/problems/xor-queries-of-a-subarray/
    public static void main( String[] args ) {
       /* int[] arr = {1, 3, 4, 8};
        int[][] queries = {
                {0, 1},
                {1, 2},
                {0, 3},
                {3, 3}
        };*/

        int[] arr = {4, 8, 2, 10};
        int[][] queries = {
                {2, 3},
                {1, 3},
                {0, 0},
                {0, 3}
        };

        System.out.println(Arrays.toString(xorQueries(arr, queries)));
    }

    //solved by me :) :D
    /*
    42 / 42 test cases passed.
    Status: Accepted
    Runtime: 1 ms
    Memory Usage: 50.1 MB
     */
    private static int[] xorQueries( int[] arr, int[][] queries ) {
        int[] prefix = new int[arr.length + 1];

        for (int i = 1; i <= arr.length; i++) {
            prefix[i] = prefix[i - 1] ^ arr[i - 1];
        }

        int[] res = new int[queries.length];
        int i = 0;
        for (int[] query : queries) {
            int first = query[0];
            int second = query[1];

            if (first == 0) {
                res[i] = prefix[second + 1];
            } else {
                res[i] = prefix[second + 1] ^ prefix[first];
            }

            i++;
        }

        return res;
    }
}
