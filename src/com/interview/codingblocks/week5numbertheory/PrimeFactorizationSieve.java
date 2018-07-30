package com.interview.codingblocks.week5numbertheory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeFactorizationSieve {

    //this method is similar to Prime Sieve but returns prime numbers between 1 to N
    private static List<Integer> solveSieve( int n ) {
        int N = n;

        boolean p[] = new boolean[1000];

        //stores prime number between 1 to N
        List<Integer> primes = new ArrayList();

        p[0] = p[1] = false;
        p[1] = true;

        //for initialization : simply marking all odd numbers as Prime.
        for (int i = 3; i <= N; i += 2) {
            p[i] = true;
        }

        for (int i = 3; i <= N; i += 2) {
            if (p[i]) {

                //Mark all multiples of numbers as not prime
                //for optimization take a Jump of : 2*i , starting from : i*i
                for (int j = i * i; j <= N; j += 2 * i) {
                    p[j] = false;
                }
            }
        }

        primes.add(2);
        for (int i = 3; i < N; i += 2) {
            if (p[i])
                primes.add(i);
        }

        return primes;
    }

    //THis solution is suggested by Prateek CodingBlocks
    //Also check GFG : https://www.geeksforgeeks.org/print-all-prime-factors-of-a-given-number/

    private static List<Integer> primeFactorize( int n, List<Integer> primes ) {

        int i = 0;
        List<Integer> factors = new ArrayList<>();

        int p = primes.get(0);

        //P is a first prime factor then P * P will be next prime factor
        // bcz inside the loop we already calculated and divides the N
        while (p * p <= n) {

            if (n % p == 0) {
                factors.add(p);

                //divide number N until this current number N MOD P
                //This helps in time complexity bcz number N divides significantly
                //and next prime factor will directly check and divide current number N
                while (n % p == 0)
                    n = n / p;
            }

            i++;
            p = primes.get(i);
        }

        //if N divides and turn into prime then add 1 extra factor of current N itself.
        if (n != 1) {
            factors.add(n);
        }

        return factors;
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Integer> primes = solveSieve(n);

       /* for (int i = 0; i < primes.length; i++) {
            System.out.print(primes.get(i) + " ");
        }*/

        List<Integer> primeFactors = primeFactorize(n, primes);

        for (Integer prime : primeFactors) {
            System.out.println(prime);
        }
    }

    public static void main( String[] args ) {
        solve();
    }
}
