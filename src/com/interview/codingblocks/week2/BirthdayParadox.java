package com.interview.codingblocks.week2;

import java.util.Scanner;

public class BirthdayParadox {

    /*
    determine the minimum number of people required in the room so that two have same birthday
     with probability greater than or equal to 'p'. (Assume there are 365 days in every year)

     Input Format:

        Single line containing the given probability.

        Constraints:
        0<p<=1
        Output Format:
        Print an integral value denoting minimum number of people.

        Sample Input:
        0.5
        Sample Output:
        23
     */
    private static void solve() {

        //probability of 2 people having same b'day : 1/365
        //probability of 2 people having different b'day : 1 - probability of 2 people having same b'day => 1 - 1/365 = 364/365
        //for 3 person having different b'day => 365/365 * 364/365 * 363/365 .....1/365
        //so Probability , Prob = 1-1/356 = 364/365 = 0.9972

        //res : X number of pairs have different b'day
        //cnt : min. number of pairs such that all of them have different b'day with probability <= P

        Scanner scanner = new Scanner(System.in);
        double P = scanner.nextDouble(); //is the probability

        int cnt = 0;
        double res = 1;
        final double finalProb = 0.9972;

        while (res > P) {
            res *= finalProb;
            cnt++;
        }

        //System.out.println("Count :" + cnt + " res :" + res);

        // if we have total pair count cnt, then n * ( n - 1 ) / 2 = cnt
        // where n is total number of people in the room
        int i = 1;
        for (; i < cnt; i++) {

            if (i * (i - 1) / 2 >= cnt) {
                break;
            }
        }

        System.out.println(i);
        // System.out.println("Min number of person have probability of B'day >= P :" + i);
    }

    private static void solveMethodTwo() {
        Scanner scanner = new Scanner(System.in);
        double P = scanner.nextDouble(); //is the probability

        int num, den, n = 0;
        double i;

        num = den = 365;

        i = 1;

        while (i > P) {
            i = (i * num) / den;
            num--;
            n++;
        }

        System.out.println(n);
    }

    public static void main( String[] args ) {
        // solve();

        solveMethodTwo();
    }
}
