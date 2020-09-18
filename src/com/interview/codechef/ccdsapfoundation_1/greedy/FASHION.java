package com.interview.codechef.ccdsapfoundation_1.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class FASHION {

    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        try {
            Scanner scanner = new Scanner(System.in);

            int t = scanner.nextInt();

            while (t-- > 0) {
                int n = scanner.nextInt();

                int[] arr = new int[n];
                int[] brr = new int[n];

                for (int i = 0; i < n; i++)
                    arr[i] = scanner.nextInt();

                for (int i = 0; i < n; i++)
                    brr[i] = scanner.nextInt();

                Arrays.sort(arr);
                Arrays.sort(brr);

                int sum = 0;
                for (int i = 0; i < n; i++) {
                    sum += arr[i] * brr[i];
                }

                System.out.println(sum);
            }
        } catch (Exception e) {
            return;
        }
    }
}
