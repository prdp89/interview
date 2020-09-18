package com.interview.codechef.ccdsapfoundation_1.Maths;

public class PrimePolynomial {

    //https://community.topcoder.com/stat?c=problem_statement&pm=4475&rd=8012
    public static void main( String[] args ) {
        // System.out.println(solve(1, 1, 41));
        System.out.println(solve(1, -15, 97));
    }

    private static int solve( int a, int b, int c ) {
        int m = 0;

        while (isPrime(a * m * m + b * m + c)) {
            m++;
        }

        return m;
    }

    private static boolean isPrime( int n ) {
        if ((n & 1) == 0) return n == 2;

        int m = (int) Math.sqrt(n) + 1;

        for (int i = 3; i < m; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
