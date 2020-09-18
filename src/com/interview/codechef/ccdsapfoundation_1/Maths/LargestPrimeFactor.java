package com.interview.codechef.ccdsapfoundation_1.Maths;

public class LargestPrimeFactor {

    public static void main( String[] args ) {
        System.out.println("answer:" + maxPrimeFactors(600851475143L));
    }

    //https://projecteuler.net/problem=3
    private static long maxPrimeFactors( long number ) {
        if (number <= 1) return -1;

        for (long i = 2; i < Math.sqrt(number); i++) {
            if (number % i == 0)
                number /= i;
        }

        return number;
    }
}
