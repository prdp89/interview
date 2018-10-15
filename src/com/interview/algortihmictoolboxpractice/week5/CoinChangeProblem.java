//package com.interview.algortihmictoolboxpractice.week5;

import java.util.Scanner;

public class CoinChangeProblem {

    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m, new int[]{1, 3, 4}));
    }

    private static int getChange( int total, int coins[] ) {
        int T[] = new int[total + 1];
        int R[] = new int[total + 1];
        T[0] = 0;

        for (int i = 1; i <= total; i++) {
            T[i] = Integer.MAX_VALUE - 1;
            R[i] = -1;
        }

        for (int j = 0; j < coins.length; j++) {
            for (int i = 1; i <= total; i++) {
                if (i >= coins[j]) {
                    if (T[i - coins[j]] + 1 < T[i]) {
                        T[i] = 1 + T[i - coins[j]];
                        R[i] = j;
                    }
                }
            }
        }
        return T[total];
    }
}
