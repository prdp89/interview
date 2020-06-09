package com.interview.leetcode.dp.lis;

import java.util.HashMap;

public class LongestArithmeticSeq {

    //https://leetcode.com/problems/longest-arithmetic-sequence/
    public static void main( String[] args ) {

    }

    //https://leetcode.com/problems/longest-arithmetic-sequence/
    //Example : [3,6,9,12]
    //store diffs found at each index. Then add to previously found diff and create max.
    /*
    0 -> {{}}
    1 -> {{3, 2}}  max = 2
    2 -> {{6, 2}, {3,3}} (adding 2 from previous)} max = 3
    3 -> {{9, 2}, {6, 3}} (adding 2 from previous) , {3, 4} (adding 3 from previous)} max = 4
    */
    public int longestArithSeqLength( int[] A ) {
        int res = 2, n = A.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int j = 0; j < A.length; j++) {

            dp[j] = new HashMap<>();

            for (int i = 0; i < j; i++) {

                int d = A[j] - A[i];
                dp[j].put(d, dp[i].getOrDefault(d, 1) + 1);
                res = Math.max(res, dp[j].get(d));
            }
        }
        return res;
    }
}
