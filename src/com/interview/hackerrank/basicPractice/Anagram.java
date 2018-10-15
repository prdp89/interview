package com.interview.hackerrank.basicPractice;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/anagram/problem
public class Anagram {

    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        if (str.length() % 2 != 0)
            System.out.println("-1");

        String left = str.substring(0, str.length() / 2);
        StringBuilder right = new StringBuilder(str.substring(str.length() / 2, str.length()));

        System.out.println(left + "  " + right);

        int count = 0;
        for (int i = 0; i < left.length(); i++) {

            if (!right.toString().contains(String.valueOf(left.charAt(i))))
                count++;
            else {
                right.deleteCharAt(right.indexOf(String.valueOf(left.charAt(i))));
            }
        }

        System.out.println(count);
    }
}
