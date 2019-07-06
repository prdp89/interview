package com.interview.codechef.ccdsap_2.atcoder.begcontest132;

import java.util.Scanner;

public class Second {

    //https://atcoder.jp/contests/abc132/tasks/abc132_b
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }


        int count = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if ((arr[i - 1] < arr[i] && arr[i] < arr[i + 1]) || (arr[i - 1] > arr[i] && arr[i + 1] < arr[i])) {
                count++;
            }
        }

        System.out.println(count);
    }
}
