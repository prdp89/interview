package com.interview.hackerrank.basicPractice;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/separate-the-numbers/problem
public class SeparateTheNumbers {

    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        boolean valid = false;
        long firstx = 0;

        // Try each possible starting number
        for (int i = 1; i <= s.length() / 2; ++i) {

            long x = Long.parseLong(s.substring(0, i));

            firstx = x;
            // Build up sequence starting with this number
            String test = Long.toString(x);

            while (test.length() < s.length()) {
                test += Long.toString(++x);
            }

            // Compare to original
            if (test.equals(s)) {
                valid = true;
                break;
            }
        }
        System.out.println(valid ? "YES " + firstx : "NO");
    }
}
