package com.interview.hackerrank.basicPractice;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/save-the-prisoner/problem
public class SaveThePrisoner {

    //this soln doesn't pass all test cases; TLE
    private static void solve() {
        int n = 5, m = 2, s = 1;

        int i = s;
        for (; i <= n; i++) {

            m--;

            if (i == n && m != 0)
                i = 0;

            if (m == 0)
                break;
        }

        System.out.println(i);
    }

    /*
    We start off at some random prisoner S and try to distribute M candies.
    So we could just do S + M to see which prisoner we end up at. However, we may have more candies than prisoners,
    so we loop back around to the first prisoner by doing the % N where N is number of prisoners.

    Each +1 and -1 that you see in the equation is to fix the off-by-one problems that exist since prisoners are
    counted from 1 to N while modular arithmetic is counted from 0.
     */

    private static void solveOptimal() {

        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();

        while (T-- > 0) {

            int N = scan.nextInt(); //number of prisoners
            int M = scan.nextInt(); //number of candies
            int S = scan.nextInt(); //start point of candy distribution

            // S + M returns which prisoner we end up having last candy.
            // But prisoner in a circular seat, we have to MOD off with N prisoner to check 1 - N prisoner in range
            // -1 done bcz prisoner counted by 1. -1 returns correct position.
            // +1 bcz MOD calculate from 0 - N-1 so +1 bring accurate result.

            int last = ((M - 1) + (S - 1)) % N + 1;

            System.out.println(last);

        }
    }

    public static void main( String[] args ) {
        // solve();

        solveOptimal();
    }
}
