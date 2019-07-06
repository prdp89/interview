package com.interview.codechef.ccdsap_2.atcoder.begcontest129;

import java.util.Scanner;

public class Balance {

    //https://atcoder.jp/contests/abc129/tasks/abc129_b
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++)
            arr[i] = scanner.nextInt();

        if (arr.length == 2)
            System.out.println(Math.abs(arr[0] - arr[1]));

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {

            int sum1 = 0, sum2 = 0;
            for (int j = 0; j <= i; j++) {
                sum1 += arr[j];
            }

            for (int k = i + 1; k < arr.length; k++) {
                sum2 += arr[k];
            }

            min = Math.min(min, Math.abs(sum1 - sum2));
        }

        System.out.println(min);
    }
}
