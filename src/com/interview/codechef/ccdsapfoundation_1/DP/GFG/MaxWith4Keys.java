package com.interview.codechef.ccdsapfoundation_1.DP.GFG;

import java.util.Arrays;

public class MaxWith4Keys {

    //https://www.geeksforgeeks.org/how-to-print-maximum-number-of-a-using-given-four-keys/
    //ref : https://www.ideserve.co.in/learn/print-maximum-number-of-a-using-four-keys-of-special-keyboard

    public static void main( String[] args ) {
        int n = 11;
        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);

        System.out.println(recurse(n, dp));
    }

    /*
    Say f(N) denotes the maximum number of As possible for N keystrokes.
    Let use see how do we compute f(N) for N = 7.

    First we choose critical point 'N_critical' as 4 (AAAA)
    We already know the value of f(4) which is 4.
    For remaining 3 keystrokes, we use Ctrl-A, Ctrl-C, Ctrl-V.
    The string of keystrokes produced will be A,A,A,A,Ctrl-A,Ctrl-C, Ctrl-V.

    These last 3 keystrokes essentially double the value of f(4). Hence for 'N_critical = 4',
    we get 8 number of As which is 2*f(4).

    That's why for N=7 we are starting loop from n-3 = 4 which computes = 2 * F(4)
     */

    //More clarity from this video:
    //https://youtu.be/nyR8K63F2KY?t=357
    private static int recurse( int n, int[] dp ) {

        if (n <= 6) return n;

        int maxSoFar = 0, multiplier = 2;

        if (dp[n] != -1)
            return dp[n];

        for (int i = n - 3; i >= 0; i--) {

            // if (dp[i] != -1)
            dp[i] = recurse(i, dp);

            int maxWithThisI = multiplier * dp[i];

            maxSoFar = Math.max(maxSoFar, maxWithThisI);

            multiplier += 1;
        }
        return maxSoFar;
    }
}
