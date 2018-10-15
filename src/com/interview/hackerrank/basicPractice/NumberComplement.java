package com.interview.hackerrank.basicPractice;

import java.util.Scanner;

public class NumberComplement {

    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // Find number of bits in the
        // given integer
        int number_of_bits =
                (int) (Math.floor(Math.log(n) /
                        Math.log(2))) + 1;


        System.out.println(((1 << number_of_bits) - 1) ^ n);
    }
}
