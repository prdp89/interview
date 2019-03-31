package com.interview.codingblocks.week6recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
    Take as input str, a string. Assume that value of a=1, b=2, c=3, d=4, …. z=26.
    Write a recursive function (return type Arraylist) to print all possible codes for the string.
    E.g. for “1123” possible codes are aabc, kbc, alc, aaw, kw.

    Sample Input:
    1125

    Sample Output:
    [aabe, aay, ale, kbe, ky]
 */
public class CODESOFTHESTRING {

    private static final String[] keys;
    private static final String[] values;

    static {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        keys = new String[alphabet.length()];
        values = new String[alphabet.length()];
        for (int i = 0; i < alphabet.length(); i++) {
            keys[i] = String.valueOf(i + 1);
            values[i] = alphabet.substring(i, i + 1);
        }
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);

        List<String> results = new ArrayList<>();
        decodeRecursive(scanner.next(), "", results);

        System.out.println(Arrays.deepToString(results.toArray()));
        /* for (String item : results) {
            System.out.println(item);
        }*/
    }

    /*
    We can break the input string 1123 into multiple calls of combination chars for (m,n).

    1: (1,0) set [1, 1, 2, 3] : pairs of 1's
    2: (2,1) sets [11, 2, 3], [1,12,3], [1,1,23] : pairs of two's
    3: (2,2) set [11,23]
    4: (3,1) set [112,3]

     */
    private static void decodeRecursive( String input, String current, List<String> results ) {

        if (input.length() == 0) {
            results.add(current);
            return;
        }

        for (int i = 0; i < keys.length; i++) {
            String key = keys[i];
            if (input.startsWith(key)) {
                decodeRecursive(input.substring(key.length()), current + values[i], results);
            }
        }
    }

    //https://hack.codingblocks.com/contests/c/452/346
    public static void main( String[] args ) {
        solve();
    }
}
