package com.interview.codingblocks.week2;

import java.util.Scanner;

public class FastPowerBitmasking {

    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);

        //A^b
        int A = scanner.nextInt();
        int b = scanner.nextInt();

        int res = 1;
        while (b > 0) {

            //if last bit is set
            int lastBit = b & 1;

            if (lastBit != 0) {
                res *= A;
            }

            //square A in each iteration
            A = A * A;

            //right shift to remove the rightmost bit; decrease power by factor of 2
            b = b >> 1;
        }

        System.out.println(res);
    }
}
