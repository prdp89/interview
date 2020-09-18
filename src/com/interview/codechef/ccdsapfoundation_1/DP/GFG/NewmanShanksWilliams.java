package com.interview.codechef.ccdsapfoundation_1.DP.GFG;

public class NewmanShanksWilliams {

    //https://www.geeksforgeeks.org/newman-shanks-williams-prime/
    public static void main( String[] args ) {
        System.out.println(nswp(4));
    }

    private static int nswp( int n ) {
        // Base case
        if (n == 0 || n == 1)
            return 1;

        // Recursive step
        return 2 * nswp(n - 1) + nswp(n - 2);
    }
}
