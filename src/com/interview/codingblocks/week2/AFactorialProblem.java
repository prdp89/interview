package com.interview.codingblocks.week2;

import java.util.Scanner;

public class AFactorialProblem {

    //reference : https://www.geeksforgeeks.org/legendres-formula-highest-power-of-prime-number-that-divides-n/
    //question source : https://hack.codingblocks.com/contests/c/473/897
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0){
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            System.out.println(largestPower(n, k));
        }
    }

    // Returns largest power of p that divides n!
    private static int largestPower( int n, int p ) {
        // Initialize result
        int x = 0;

        // Calculate x = n/p + n/(p^2) + n/(p^3) + ....
        while (n != 0) {
            n /= p;
            x += n;
        }
        return x;
    }
}
