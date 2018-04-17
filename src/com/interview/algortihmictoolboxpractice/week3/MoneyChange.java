//package com.interview.algortihmictoolboxpractice.week3;

import java.util.Scanner;

public class MoneyChange {
    private static int getChange( int m ) {
        int minCoins = 0;

        while (m > 0) {

            if (m >= 10) {
                m -= 10;
                minCoins++;
            } else if (m >= 5) {
                m -= 5;
                minCoins++;
            } else {
                m--;
                minCoins++;
            }

        }
        return minCoins;
    }

    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

