package com.interview.codechef.ccdsap_2.atcoder.begcontest133;

import java.util.Scanner;

public class GoodDistance {

    //https://atcoder.jp/contests/abc133/tasks/abc133_b
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int d = scanner.nextInt();

        int[][] arr = new int[n][d];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < d; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        //generating N*N pairs
        int count = 0;
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                int sum = 0;
                for (int k = 0; k < d; k++) {

                    int value = Math.abs(arr[i][k] - arr[j][k]);
                    sum += (value * value);
                }

                double sqrt = Math.sqrt(sum);
                if (sqrt == (int) (sqrt))
                    count++;
            }
        }

        System.out.println(count);
    }
}
