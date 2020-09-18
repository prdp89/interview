package com.interview.codechef.ccdsapfoundation_1.DP.GFG;

public class DiceThrowWays {

    //https://www.geeksforgeeks.org/dice-throw-dp-30/
    public static void main( String[] args ) {
        System.out.println(recurse(6, 3, 8));
    }

    private static int recurse( int m, int n, int sum ) {
        if (sum == 0 && n == 0)
            return 1;

        if (sum <= 0)
            return 0;

        if (n <= 0)
            return 0;

        int result = 0;

        for (int j = 1; j <= m; ++j) {
            result += recurse(m, n - 1, sum - j);
        }

        return result;
    }
}
