package com.interview.codingblocks.week1;

import java.util.Scanner;

public class XORProfit {

    //XOR profit : https://hack.codingblocks.com/contests/c/101/498

    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int max = 0;
        for (int i = a; i < b; i++) {

            int temp = i ^ b;

            if (temp > max)
                max = temp;

        }
        System.out.println(max);
    }
}
