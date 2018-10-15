package com.interview.hackerrank.basicPractice;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/the-love-letter-mystery/problem
public class TheLoveLetterMystery {

    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        int count = 0;

        for (int i = 0, j = str.length() - 1; i < str.length() / 2; i++, j--) {

         /*   if (str.charAt(i) < str.charAt(j)) {
                count += str.charAt(j) - str.charAt(i);
            } else if (str.charAt(i) > str.charAt(j))
                count += str.charAt(i) - str.charAt(j);*/

            //or simplify............

            count += Math.abs(str.charAt(j) - str.charAt(i));
        }

        System.out.println(count);
    }
}
