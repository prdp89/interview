package com.interview.codechef.ccdsapfoundation_1.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MAXDIFF {

    //https://www.codechef.com/problems/MAXDIFF
    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();

            while (t-- > 0) {
                int n = scanner.nextInt();
                int k = scanner.nextInt();

                //array should split into min K items
                k = Math.min(k, n - k);

                int[] arr = new int[n];
                for (int i = 0; i < n; i++)
                    arr[i] = scanner.nextInt();

                Arrays.sort(arr);

                int sonWeights = 0, fatherWeights = 0;
                for (int i = 0; i < n; i++) {

                    if (k-- > 0) {
                        sonWeights += arr[i];
                    } else
                        fatherWeights += arr[i];
                }

                System.out.println(Math.abs(fatherWeights - sonWeights));
            }
        } catch (Exception e) {
            return;
        }
    }
}