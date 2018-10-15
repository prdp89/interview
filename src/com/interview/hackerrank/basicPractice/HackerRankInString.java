package com.interview.hackerrank.basicPractice;

import java.util.Scanner;

public class HackerRankInString {

    //https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem
    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        String hacker = "hackerrank";

        if (hacker.length() > s.length())
            System.out.println("NO");

        int count = 0;

        for (int i = 0, j = 0; i < s.length(); i++) {

            if (j < hacker.length() && s.charAt(i) == hacker.charAt(j)) {
                count++;
                j++;
            }
        }

        if (count == hacker.length())
            System.out.println("YES");
        else
            System.out.println("NO");

    }
}
