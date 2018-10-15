package com.interview.hackerearth.octeasy2k18;

import java.util.Scanner;

public class AliHelping {

    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        char[] s = scanner.next().toCharArray();

        if (checkVowel(s[2])) {
            System.out.println("invalid");
            return;
        }

        for (int i = 1; i < s.length; i++) {

            if ((s[i] >= 65 && s[i] <= 90) || s[i] == '-')
                i += 2;

            int cur = Character.getNumericValue(s[i]);
            int prev = Character.getNumericValue(s[i - 1]);

            if ((cur + prev) % 2 != 0) {
                System.out.println("invalid");
                break;
            }
        }

        System.out.println("valid");
    }

    private static boolean checkVowel( char c ) {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'Y';
    }
}
