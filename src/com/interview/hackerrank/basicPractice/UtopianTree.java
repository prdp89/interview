package com.interview.hackerrank.basicPractice;

import java.util.Scanner;

public class UtopianTree {

    //https://www.hackerrank.com/challenges/utopian-tree/
    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n > 0) {
            int initialHeight = 1;
            for (int i = 1; i <= n; i++) {

                //number is odd
                if ((i & 1) != 0) {
                    initialHeight *= 2;
                } else
                    initialHeight += 1;
            }

            System.out.println(initialHeight);
        } else
            System.out.println(1);

    }

    public static void main( String[] args ) {
        solve();
    }
}
