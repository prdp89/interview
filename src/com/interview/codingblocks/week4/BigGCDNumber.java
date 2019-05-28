package com.interview.codingblocks.week4;

import java.util.Scanner;

public class BigGCDNumber {

    /*
    Basic Euclidean Algorithm for GCD
    The algorithm is based on below facts.

    If we subtract smaller number from larger (we reduce larger number), GCD doesn’t change.
    So if we keep subtracting repeatedly the larger of two, we end up with GCD.

    Now instead of subtraction, if we divide smaller number, the algorithm stops when we find remainder 0.
     */
    private static void solveGCDIterative( int a, int b ) {
      /*  Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();*/

        int aComplement = a % b;
        while (aComplement != 0) {
            a = b;
            b = aComplement;
            aComplement = a % b;
        }

        System.out.println(b);
    }

    private static void solveBigGCD() {

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        char[] b = scanner.next().toCharArray();

        int res = 0;
        for (int i = 0; i < b.length; i++) {

            int digit = (b[i] - '0');
            res = (res * 10 + digit) % a;
        }

        if (res != 0)
            solveGCDIterative(a, res);
        else
            System.out.println(a);
        //System.out.println(res);
    }

    public static void main( String[] args ) {
        //solveGCDIterative(12, 15);

        solveBigGCD();
    }
}
