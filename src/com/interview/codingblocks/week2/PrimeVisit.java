package com.interview.codingblocks.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class PrimeVisit {

    //question: https://hack.codingblocks.com/contests/c/452/63
    private static void primeNumberInRange() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int count;

        while (testCases-- > 0) {

            count = 0;
            int start = scanner.nextInt();
            int n = scanner.nextInt();

            List<Boolean> prime = new ArrayList<>();

            for (int i = 0; i < n; i++)
                prime.add(0, false);

            for (int p = 2; p <= Math.sqrt(n); p++) {
                // If prime[p] is not changed, then it is a prime
                if (!prime.get(p)) {

                    // Update all multiples of p
                    //if p= 2 then i starts from : i = 4 and remove all numbers in prime array;
                    // as i+=p => 4+2 = 6; 6+2 = 8 will be the next numbers

                    for (int i = p * 2; i <= n; i += p)
                        prime.add(i, true);
                }
            }

            for (int i = n; i >= start; i--)
                if (!prime.get(i) && i != 1)
                    count++;

            System.out.println(count);

        }
    }

    private static Vector<Integer> calculateNPrimeUsingSimpleSieve( int max ) {
        // final int max = 100001;
        boolean isPrime[] = new boolean[max];

        for (int i = 0; i < max; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i < max; i++) {

            if (isPrime[i]) {

                for (int j = i * i; j < max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        Vector<Integer> primes = new Vector<>();
        primes.add(2);

        for (int i = 3; i < max; i += 2) {
            if (isPrime[i])
                primes.add(i);
        }

        return primes;
    }

    private static void segmentedSieve() {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();

        while (test-- > 0) {
            long start = scanner.nextLong();
            long n = scanner.nextLong();

            long temp;
            if(start > n){
                temp = start;
                start = n;
                n = temp;
            }
            //int limit = (int) Math.floor(Math.sqrt(n)) + 1;
            Vector<Integer> primes = calculateNPrimeUsingSimpleSieve((int)n);

            printPrimes(start, n, primes);
        }
    }

    private static void printPrimes( long start, long n, Vector<Integer> primes ) {
        boolean isPrime[] = new boolean[(int) (n - start + 1)];

        //creating a END - Start range to store the prime and init it true.
        for (int i = 0; i <= n - start; i++)
            isPrime[i] = true;

        //Similar to simple sieve : i * i < n; if prime.get(i) = 2 that means 2,4,6,8.. are already checked;
        // so doing prime.get(i) * prime.get(i) help in starts from 9 in next iteration as prime.get(i+1) will be 3.
        //Now we have calculated prime from 2 ... MAX. So we are doing its multiple <= END RANGE

        for (int i = 0; primes.get(i) * primes.get(i) <= n; i++) {

            int currPrime = primes.get(i);

            //if currPrime = 2; start =1, end = 10
            //so: 1/2 = 0 ; 0*2= 0 => base = 0
            long base = (start / (currPrime)) * (currPrime);

            //if 0 < 1 then we atleast start from current prime number by adding=> base = 0 + 2 => 2
            if (base < start)
                base = base + currPrime;

            for (long j = base; j <= n; j += currPrime) {

                //j-start means: we are setting only Start -- END range value to false.
                isPrime[(int) (j - start)] = false;
            }

            //checking if upper loop doesn't set the Prime number to false
            // currPrime is a prime number, so if it equals to base means in last loop isPrime[2] has been false
            //now we are setting it again to true state.
            if (base == currPrime)
                isPrime[(int) (base - start)] = true;
        }

        int count = 0;
        for (int i = 0; i <= n - start; i++) {
            if (isPrime[i] && i + start != 1)
                count++;
            //i+start means: we are printing only Start -- END range values.
            //System.out.println(i + start);
        }

        System.out.println(count);
    }

    public static void main( String[] args ) {
        segmentedSieve();
    }
}
