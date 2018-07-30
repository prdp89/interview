package com.interview.codingblocks.week4;

import java.util.Scanner;

public class PrimeSieveOptimized {

    //This method calculated Primes numbers from 0 - N
    private static boolean[] solveSieveOptimized() {
        Scanner n = new Scanner(System.in);
        int N = n.nextInt();

        boolean p[] = new boolean[N];

        p[0] = p[1] = false;
        p[1] = true;

        //if N is smaller than i = 3
        if (N <= 3)
            return p;

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

        for (int i = 0; i < N; i++) {
            if (p[i])
                System.out.print(i + " ");
        }

        return p;
    }

    //This method is use to calculate prime numbers in range A to B
    //We first calculate Primes in Range : 1 - root B
    //Then we create an array of (A-B+1) and mark all those values to false which is divisible by bith element.

    //this code doesn't proper but concept is same as Prime Visit in week-3
    private static void segementedSieve() {

        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        //step1 :calculate Primes in Range : 1 - root B
        boolean b[] = solveSieveBasic(B);

        //step2 : create an array of (B - A + 1)
        boolean ss[] = new boolean[B - A + 1];

        //iterating from 2...root B, same as normal prime : 2-SQRT(n)
        for (int i = 0; i * i <= B; i++) {
            for (int j = A; j <= B; j++) {

                //if b[i] element is prime
                if (b[i]) {

                    if (j == i) continue;

                    //calculating MOD of (A-B) with b[] indices.
                    if (j % i == 0)
                        ss[j - A] = false;  //adjusting the values acc. to index.
                }
            }
        }

        int res = 1;
        for (int i = A; i < B; i++) {
            res += ss[i - A] ? 1 : 0;
        }

        System.out.println(res);
    }

    private static boolean[] solveSieveBasic( int B ) {

        boolean b[] = new boolean[B];

        for (int i = 0; i < B; i++)
            b[i] = true;

        for (int i = 2; i < B; i++) {
            if (b[i]) {
                for (int j = 2 * i; j < B; j += i) {
                    b[j] = false;
                }
            }
        }

        return b;
    }

    public static void main( String[] args ) {
        //solveSieve(0);

        segementedSieve();
    }
}
