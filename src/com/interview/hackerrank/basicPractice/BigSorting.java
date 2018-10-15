package com.interview.hackerrank.basicPractice;

import java.util.Arrays;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/big-sorting
public class BigSorting {

    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[] arr = new String[n];

        for (int i = 0; i < n; i++)
            arr[i] = scanner.next();

        Arrays.sort(arr, ( o1, o2 ) -> {
            if (o1.length() == o2.length())
                return o1.compareTo(o2);

            //if this doesn't happen we have to check in loop for each character
            return o1.length() - o2.length();
        });

        for (int i = 0; i < n; i++)
            System.out.println(arr[i]);
    }
}
