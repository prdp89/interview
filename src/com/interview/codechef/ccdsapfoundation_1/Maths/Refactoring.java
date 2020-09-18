package com.interview.codechef.ccdsapfoundation_1.Maths;

public class Refactoring {

    //https://community.topcoder.com/stat?c=problem_statement&pm=2986&rd=5862
    public static void main( String[] args ) {
        System.out.println(refactor(24));
    }

    private static int refactor( int n ) {

        return count(n, 2);
    }

    private static int count( int n, int index ) {

        if (n == 0)
            return 0;

        int result = 0;

        for (int i = index; i * i <= n; i++) {
            if (n % i == 0) {
                result += count(n / i, i) + 1; //similar to PrimeFactorizationSieve.
            }
        }

        return result;
    }
}
