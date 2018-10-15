package com.interview.hackerrank.basicPractice;

import java.util.Scanner;

public class DrawingBook {

    //https://www.hackerrank.com/challenges/drawing-book/
    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();

        //if even then user flip one extra page
        int numberOfFlips = (n & 1) != 1 ? 1 : 0;

        //checking flip from front or back
        int minFlips = Math.min(p - 1, n - p);

        if (p == 0 || p == n)
            System.out.println(0);
        else
            System.out.println(minFlips / 2 + numberOfFlips);
    }

    private static void solveBest() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        System.out.println(Math.min(p/2, n/2-p/2));
    }

    public static void main( String[] args ) {
        solve();
    }
}
