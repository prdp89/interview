package com.interview.hackerrank.basicPractice;

import java.util.Scanner;

public class SOS {

    //https://www.hackerrank.com/challenges/mars-exploration/problem
    public static void main( String[] args ) {
        solve();
    }

    //passes all test cases
    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        int count = 0;

        for (int i = 0; i < s.length(); i += 3) {

            if (i + 2 < s.length() && !s.substring(i, Math.min(s.length(), i+3)).equals("SOS")) {
                char[] str = s.substring(i, i + 3).toCharArray();
                if (str[0] != 'S')
                    count++;

                if (str[1] != 'O')
                    count++;

                if (str[2] != 'S')
                    count++;
            }

        }
        System.out.println(count);
    }

    //better solution than your's
    public static int countChanges(String message) {
        String sos = "SOS";
        int count = 0;
        for (int i = 0; i < message.length(); i+=3) {

            if (message.charAt(i) != sos.charAt(i % 3)) count++;

        }
        return count;
    }
}

