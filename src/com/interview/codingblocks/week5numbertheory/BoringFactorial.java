package com.interview.codingblocks.week5numbertheory;

import java.util.Scanner;

public class BoringFactorial {

    private static long fastModuloExponentation( long a, long b, long m ) {
        long res = 1;

        while (b > 0) {

            if ((b & 1) != 0) {
                res = (res * a) % m;
            }

            a = (a * a) % m;
            b = b >> 1;
        }

        return res;
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);

        long t = scanner.nextLong();


        while (t-- > 0) {
            long n = scanner.nextLong();
            long p = scanner.nextLong();

            //case 1 : if N > p then result will be zero. check notes.
            if (n >= p)
                System.out.println(0);
            else {
                System.out.println(calcNFactorialModP(n, p));
            }
        }
    }

    private static long calcNFactorialModP( long n, long p ) {
        long ans = -1;

        for (long i = (n + 1); i <= (p - 1); i++) {

            //calculating multiplication of N terms upto (P - 1) after doing (A ^ b % b)
            long temp = fastModuloExponentation(i, p - 2, p);
            ans = (ans * temp) % p;
        }

        return ans + p;
    }

    public static void main( String[] args ) {
        solve();
    }
}
