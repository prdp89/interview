package com.interview.codechef.ccdsap_2.leetcode.contests.contest139;

import java.util.Arrays;

public class FlipColumnForMaxRows {

    //https://leetcode.com/contest/weekly-contest-139/problems/flip-columns-for-maximum-number-of-equal-rows/
    public static void main( String[] args ) {
        int[][] arr = {
                {0, 0, 0},
                {0, 0, 1},
                {1, 1, 0}
        };

        System.out.println(maxEqualRowsAfterFlips(arr));
    }

    //ref : https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/discuss/303897/Java-easy-solution-%2B-explanation


    private static int maxEqualRowsAfterFlips( int[][] matrix ) {

        int ans = 0;

        int m = matrix.length, n = matrix[0].length;

        int[] flip = new int[n];

        for (int i = 0; i < m; i++) {

            int cnt = 0;

            //This loop stores the ith row flipped values.
            //We are checking by flipping each row values. Storing Max for each of them(row).
            for (int j = 0; j < n; j++)
                flip[j] = 1 - matrix[i][j]; //flip zero to one or vice-versa

            //1. Comparing if ith row is equals to next kth row
            //2. Comparing if Kth row equals to Flipped row values
            //If any conditions satisfies, means both rows are equals (can be all zero's or all one's)
            for (int k = 0; k < m; k++) {
                if (Arrays.equals(matrix[k], matrix[i]) || Arrays.equals(matrix[k], flip)) cnt++;
            }

            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
