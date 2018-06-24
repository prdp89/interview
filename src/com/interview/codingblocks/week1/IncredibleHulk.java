package com.interview.codingblocks.week1;

import java.util.Scanner;

public class IncredibleHulk {

    private static void solve() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {

            int j = 0, temp = arr[i];
            while (temp > 0) {

                temp = temp & (temp - 1);
                j++;
            }
            System.out.print(j + " ");
        }
    }

    public static void main( String[] args ) {
        solve();
    }
}
