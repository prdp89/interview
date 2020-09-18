package com.interview.leetcode.contests._new_weekely.weekely201;

import java.math.BigInteger;
import java.util.HashMap;

public class Problem1 {

    public static void main( String[] args ) {
        String str = "111";
        //System.out.println(numStepsOptimal(str));

        // System.out.println(largestDivisibleSubset_Optimal(new int[]{-3, -2, 1, 0, 8, 7, 1}, 3));
        System.out.println(largestDivisibleSubset_Optimal(new int[]{7, 1, 11, 8, 4, 10}, 8));
    }

    private static int numStepsOptimal( String s ) {
        int ans = 0;
        while (s.length() > 1) {
            ans++;

            //equivalent to divide by 2
            if (s.charAt(s.length() - 1) == '0')
                s = s.substring(0, s.length() - 1);
            else {
                BigInteger bi = new BigInteger(s, 2);

                s = bi.subtract(new BigInteger("1")).toString(2);
            }
        }

        return ans + 1;
    }

    private static int largestDivisibleSubset_Optimal( int[] A, int m ) {
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
