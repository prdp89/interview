package com.interview.codechef.ccdsapfoundation_1.Maths;

public class SumSquareDifference {

    //https://projecteuler.net/problem=6
    public static void main( String[] args ) {
        System.out.println(solve(100));
    }

    private static long solve( int n ) {
        long num1 = (n * (n + 1)) / 2;
        long num2 = ((n * n * n) / 3) + ((n * n) / 2) + (n / 6);
        return (num1 * num1) - num2 - 1;
    }
}
