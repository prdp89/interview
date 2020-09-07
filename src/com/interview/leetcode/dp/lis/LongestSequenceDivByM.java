package com.interview.leetcode.dp.lis;

import java.util.HashMap;
import java.util.Map;

public class LongestSequenceDivByM {

    /*
        Find the largest Subset where absolute difference between each element would be divisible by M.
         -3, -2, 1, 0, 8, 7, 1

         valid subset = {-2, 1, 7, 1} = length = 4
         eg: abs(-2 - 1) = 3 is divisible by M = 3
     */

    //https://leetcode.com/discuss/interview-question/812680/grab-android-dev-india-rejected/672189
    public static void main( String[] args ) {
        int[] arr = {-3, -2, 1, 0, 8, 7, 1};
        int m = 3;

        Map<Integer, Integer> map = new HashMap<>();

        //We need that for all pairs (x-y) is divisible by M,
        // this is equivalent to the fact that x and y gives the same residue when you divide by M.

        //eg: -2 MOD 3 = -2 + 3 = 1 and
        //    1 MOD 3 = 1
        //So both {-2, 1} belong to same subset bcz both produces the same res = 1
        for (int item : arr) {
            int res = item % m;

            if (res < 0) //to prevent -ve element
                res += m;

            map.put(res, map.getOrDefault(res, 0) + 1);
        }

        int ans = 0;
        for (int key : map.keySet()) {
            ans = Math.max(ans, map.get(key));
        }

        System.out.println(ans);
    }

    //This solution has submitted in Online test..
    private static int largestDivisibleSubset_test_grab( int[] A, int m ) {
        int res = 0, n = A.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];

        for (int j = 0; j < A.length; j++) {

            dp[j] = new HashMap<>();

            for (int i = 0; i < j; i++) {

                int d = Math.abs(A[j] - A[i]);

                dp[j].put(d, dp[i].getOrDefault(d, 1) + 1);

                if (d % m == 0)
                    res = Math.max(res, dp[j].get(d));
            }
        }

        return res + 1;
    }
}
