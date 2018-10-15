package com.interview.hackerearth.augustcircuit2k18;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class EqualMedian {

    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

       /* int rotation = 1;
        int first = a[0];

        for (int i = 0; i < n - 1; i++) {
            //System.out.print(a[rotation % n] + " ");
            a[i] = a[rotation % n];
            rotation++;
        }

        a[n - 1] = first;
        System.out.println(Arrays.toString(a));

        int last = b[n - 1];
        for (int i = n - 1; i > 0; i--) {
            b[i] = b[i-1];
        }

        b[0] = last;

        System.out.println(Arrays.toString(b));*/

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {

            if (a[i] < b[j]) {

            }
        }
    }
}
