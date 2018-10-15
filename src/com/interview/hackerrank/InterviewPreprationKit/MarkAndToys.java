package com.interview.hackerrank.InterviewPreprationKit;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class MarkAndToys {

    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[n];

        int maxLimit = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        Arrays.sort(a);

        int sum = a[0];
        int i = 1;

        for (; i < a.length; i++) {

            if (sum < maxLimit)
                sum += a[i];
            else
                break;
        }

        System.out.println(i - 1);
    }
}
