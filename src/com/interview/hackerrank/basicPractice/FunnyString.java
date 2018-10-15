package com.interview.hackerrank.basicPractice;

import java.util.Scanner;

public class FunnyString {

    //https://www.hackerrank.com/challenges/funny-string/problem
    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        char[] str = scanner.next().toCharArray();

        int j = str.length - 1;

        StringBuilder s = new StringBuilder();
        StringBuilder t = new StringBuilder();

        for (int i = 1; i < str.length && j > 0; i++, j--) {

            s.append(Math.abs(str[i] - str[i - 1]));

            //if (j > 0)
            t.append(Math.abs(str[j] - str[j - 1]));

        }

        System.out.println(s.toString().equals(t.toString()) ? "Funny" : "Not Funny");
    }
}
