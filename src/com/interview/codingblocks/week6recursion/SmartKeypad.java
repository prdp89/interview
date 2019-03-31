package com.interview.codingblocks.week6recursion;

import java.util.Scanner;

public class SmartKeypad {

    private static String table1[] = {" ", ".+@$", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"};

    private static void solve( String input, char[] out, int i, int j ) {

        //if 'i' reaches end of input string; then start printing string recursively
        //and output last char should not be null
        if (i > input.length() - 1 && out[out.length - 1] != '\u0000') {
            System.out.println(out);
            return;
        }

        //if 'i th ' index is less that input string length then only go for next recursion
        if (i < input.length()) {
            int digitIndex = input.charAt(i) - '0'; //convert 1 to digit 1; So that we can get index of table Array

            //if char occur like 2113 : then our recursion should not stuck at 1 and we call on next index.
            if (digitIndex == 1 || digitIndex == 0)
                solve(input, out, i + 1, j);

            //checking until K reaches end of mapped input length. e.g 2 = abc
            for (int k = 0; k < table1[digitIndex].length(); k++) {

                out[j] = table1[digitIndex].toCharArray()[k];

                //this recursion continue until i reaches end of input: eg 23 : i goes till length = 2
                // 'J' help in stores the char at position
                solve(input, out, i + 1, j + 1);
            }
        }
    }

    //https://hack.codingblocks.com/contests/c/452/96
    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.next();
        char[] arr = new char[input.length()];

        solve(input, arr, 0, 0);
    }
}
