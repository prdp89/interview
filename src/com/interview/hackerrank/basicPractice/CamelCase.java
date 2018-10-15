package com.interview.hackerrank.basicPractice;

import java.util.Scanner;

public class CamelCase {

    //https://www.hackerrank.com/challenges/camelcase/problem
    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        // char[] s = "saveChangesInTheEditor".toCharArray();

        Scanner scanner = new Scanner(System.in);
        char[] s = scanner.next().toCharArray();

        int count = 1;
        for (int i = 1; i < s.length; i++) {

            if ((int) s[i] >= 65 && (int) s[i] <= 90)
                count++;
        }

        System.out.println(count);
    }
}
