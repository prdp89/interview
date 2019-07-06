package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

public class IntegerBreak {

    static int max = 0;

    //https://leetcode.com/problems/integer-break/
    public static void main( String[] args ) {
        int n = 10;
        int start = 2;

        //System.out.println(recurse(10));

        System.out.println(integerBreak(10)); // op  = 36 -> {4 * 3 * 3}
    }

    //not working at all....... :(
    private static int recurse( int n ) {

        if (n <= 0) {
            return 1;
        }

        int ways = Integer.MIN_VALUE;
        for (int i = 2; i <= n; i++) {
            ways = i * recurse(n - i);
        }

        max = Math.max(ways, max);
        return ways;
    }


    // ref : https://leetcode.com/problems/integer-break/discuss/80860/Java-dprecursive-solution-runs-0ms
    private static int integerBreak( int n ) {

        if (n <= 3)
            return n - 1;
        else if (n == 4)
            return n;

        int[] dp = new int[n + 1];

        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;

        return integerBreak(n, dp);
    }

    private static int integerBreak( int n, int[] dp ) {
        if (dp[n] != 0)
            return dp[n];

        int ret = Math.max(integerBreak(n - 2, dp) * 2, integerBreak(n - 3, dp) * 3);
        dp[n] = ret;
        return ret;
    }


}
