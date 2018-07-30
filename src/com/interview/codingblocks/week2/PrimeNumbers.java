package com.interview.codingblocks.week2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumbers {

    //Reference: https://medium.com/i-math/prime-numbers-the-sieve-of-eratosthenes-ee22c119b6de
    //source : https://www.geeksforgeeks.org/sieve-of-eratosthenes/
    //Time complexity : O(n LogLogN)

    static void sieveOfEratosthenes( int n ) {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i < n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a prime
            if (prime[p] == true) {

                // Update all multiples of p
                //if p= 2 then i starts from : i = 4 and remove all numbers in prime array;
                // as i+=p => 4+2 = 6; 6+2 = 8 will be the next numbers

                for (int i = p * 2; i <= n; i += p)
                    prime[i] = false;
            }
        }

        // Print all prime numbers
        for (int i = 2; i <= n; i++) {
            if (prime[i] == true)
                System.out.print(i + " "); //where i is a prime number if condition is true
        }
    }

    //Question : https://hack.codingblocks.com/contests/c/473/700

    // The fully naive trial division is dreadfully slow.
    // The first step to a better algorithm is the realisation that
    // none of the numbers between n/2 and n can be a divisor of n,
    // so we can stop testing at n/2, reducing the running time by
    // roughly half. This is a surprisingly common implementation.
    private static boolean isPrimeNBy2( int n ) {
        int m = n / 2 + 1;
        for (int i = 2; i < m; ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    // Stopping at n/2 is still way too slow to find the n-th
    // prime for larger n.
    // So we start to think. If n/2 is a divisor of n, then
    // n = 2*(n/2), so 2 is a divisor too, and the testing
    // loop never reaches n/2, hence we can stop even earlier.
    // Now, the next largest possible divisor of n is n/3.
    // But if n/3 is a divisor of n, so is 3, and the loop
    // won't go further than 3. The next largest -
    //
    // Hey, wait a minute. 2 <-> n/2, 3 <-> n/3 ...
    // The divisors of n come in pairs, d and n/d.
    // Unless d = sqrt(n), one of these two, say d, is smaller
    // than the other and hence d*d < d*(n/d) = n, so d < sqrt(n).
    //
    // If n is composite, at least one of its nontrivial divisors is
    // not larger than sqrt(n).
    // That means we can stop our loop at sqrt(n). First BIG step.
    //
    // This improvement reduces the complexity of the algorithm.
    // Testing primarily of n has dropped from O(n) to O(sqrt(n)),
    // so the overall complexity of finding the n-th prime has
    // dropped from O(n^2 * log n) to O(n^1.5 * sqrt(log n)) -
    // or so, I haven't done it properly and may have gotten
    // the exponent of the log factor wrong.
    private static boolean isPrimeSqrt( int n ) {
        int m = (int) Math.sqrt(n) + 1;
        for (int i = 2; i < m; ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    //source : https://bitbucket.org/dafis/javaprimes/src
    private static void nthPrimeBasic( int n ) {
        int candidate, count;
        for (candidate = 2, count = 0; count < n; ++candidate) {
            /*if (isPrimeNBy2(candidate)) {
                ++count;
            }*/

            if (isPrimeSqrt(candidate)) {
                ++count;
            }
        }
        System.out.println(candidate - 1);
    }


    // While we're at it, let's think about further improvements.
    // All primes except 2 are odd, and odd numbers cannot have
    // even divisors, so let's skip these in the test.
    // This reduces the running time by another factor of about 2.
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

    // While we're at it, let's think about further improvements.
    // All primes except 2 are odd, and odd numbers cannot have
    // even divisors, so let's skip these in the test.
    // This reduces the running time by another factor of about 2.
    private static boolean isPrime_Sqrt_Odd( int n ) {
        //if first prime number
        if ((n & 1) == 0) return n == 2;

        int m = (int) Math.sqrt(n) + 1;
        for (int i = 3; i < m; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void nthPrime_Sqrt_Odd( int n ) {
        if (n < 2) System.out.println(2);

        int candidate, count;

        for (candidate = 3, count = 1; count < n; candidate += 2) {
            if (isPrime_Sqrt_Odd(candidate)) {
                ++count;
            }
        }
        System.out.println(candidate - 2);
    }

    // Pursuing the wheel idea - which doesn't reduce the complexity
    // of the algorithm, only the constant factors - further, in our
    // particular setting, we can get an algorithmic improvement.
    // Since we find all primes below the target, we can store them
    // as we find them and use only primes as candidate divisors.
    // For trial division, this is optimal, we never divide by a number
    // that has previously been determined not to be a divisor of n.
    // Reduces the complexity of the algorithm by a factor of log n or so
    // compared to the wheel.
    private static boolean isPrime_Sqrt_Primes( int n, int[] primes, int primeCount ) {
        int m = (int) Math.sqrt(n) + 1;
        for (int i = 0, p; i < primeCount && (p = primes[i]) < m; ++i) {
            if (n % p == 0) {
                return false;
            }
        }
        return true;
    }

    public static void nthPrime_Sqrt_Primes( int n ) {
        if (n < 2) System.out.println(2);
        if (n == 2) System.out.println(3);
        if (n == 3) System.out.println(5);
        // We're skipping multiples of 2 or 3, so we can cheat and never test
        // our candidates for divisibility by those. Thus we start with 5 as
        // our first prime and have to adjust the target accordingly.
        n -= 2;

        // Wasting space, we never divide by a prime that large, but
        // it's simpler to store all and reaching the range where
        // space becomes a problem would still take far too long.
        int[] primes = new int[n];
        primes[0] = 5;
        int candidate, count, step = 2;
        for (candidate = 7, count = 1; count < n; step = 6 - step, candidate += step) {
            if (isPrime_Sqrt_Primes(candidate, primes, count)) {
                primes[count] = candidate;
                ++count;
            }
        }
        System.out.println(primes[n - 1]);
    }

    // Now we start becoming serious.
    // A simple sieve of Eratosthenes, the only optimisation -
    // already known in antiquity - is to start ticking off
    // multiples of primes at the square.
    // The complexity of sieving to the limit N is O(N * log (log N)),
    // since the n-th prime is approximately n*log n, the complexity
    // of finding the n-th prime with the sieve is O(n*log n*log(log n)).

    //to solve question: https://hack.codingblocks.com/contests/c/473/700
    private static void nthPrime_Seive( int n ) {

        if (n < 2) System.out.println(2);
        if (n == 2) System.out.println(3);
        if (n == 3) System.out.println(5);

        int limit, root, count = 0;

        // Approximation of the n-th prime, overestimates for n >= 3.
        limit = (int) (n * (Math.log(n) + Math.log(Math.log(n)))) + 3;

        //sqrt is done to calculate only n/2 primes as method-1 or method-2
        root = (int) Math.sqrt(limit) + 1;

        boolean[] sieve = new boolean[limit];

        for (int i = 2; i < root; ++i) {
            // Since Java initialises the array to false,
            // we mark composites as true to save the extra
            // initialisation pass.
            if (!sieve[i]) {

                //counting numbers of primes
                ++count;
                for (int j = i * i; j < limit; j += i) {
                    //setting true here means; removing numbers which r not prime.
                    sieve[j] = true;
                }
            }
        }

        int p;
        for (p = root; count < n; ++p) {
            //fetching only remaining false value.
            if (!sieve[p]) {
                //incrementing number of primes until we reach N
                ++count;
            }
        }
        System.out.println(p - 1); //similar to basic seive method, index is the prime number
    }

    //This returns TLE for big Numbers
    private static void nthPrimeBigInteger(int n){
        BigInteger prime = BigInteger.valueOf(0);
        for (int i = 0; i < n; i++) {
            prime = prime.nextProbablePrime();
        }
        System.out.println(prime.intValue());
    }

    //question : https://hack.codingblocks.com/contests/c/473/760
    //We should use Segmented Sieve in this question : this return TLE in some cases.
    static void primeNumberInRange() {
        List<Integer> list = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0){
            int start = scanner.nextInt();
            int n = scanner.nextInt();

            boolean prime[] = new boolean[n + 1];

            for (int p = 2; p <= Math.sqrt(n); p++) {
                // If prime[p] is not changed, then it is a prime
                if (!prime[p]) {

                    // Update all multiples of p
                    //if p= 2 then i starts from : i = 4 and remove all numbers in prime array;
                    // as i+=p => 4+2 = 6; 6+2 = 8 will be the next numbers

                    for (int i = p * 2; i <= n; i += p)
                        prime[i] = true;
                }
            }

            // Print all prime numbers
            for (int i = start; i <= n; i++) {
                if (!prime[i])
                    list.add(i);
                    //System.out.println(i); //where i is a prime number if condition is true
            }
        }

        for (Integer i: list) {
            System.out.println(i);
        }
    }

    //source : https://bitbucket.org/dafis/javaprimes/src
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        //Method-1
        //nthPrimeBasic(scanner.nextInt());

        //Method-2
        // nthPrime_Sqrt_Odd(scanner.nextInt());

        //Method-3
        //nthPrime_Sqrt_Primes(scanner.nextInt());

        //Method-4
        //nthPrime_Seive(scanner.nextInt());

        //Method-5
        //nthPrimeBigInteger(scanner.nextInt());

        primeNumberInRange();
    }
}
