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

    //ref : https://leetcode.com/problems/decode-ways/discuss/30357/DP-Solution-(Java)-for-reference
    /*
    I am trying to add some notes to the code to make everybody understand better.
    Take manky's code as example. Assigning memo[n] = 1; means when the string is empty, there is only one answer.

    memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0; means when there is only one character in the string,
    if this character is not 0, there will be an answer, or there will be no answer.

    Then it starts the dp portion. When we add a letter from the end of the string,
    if the first two letters <=26, we can get memo[n]=memo[n+1]+memo[n+2]. For example,
    the String now is "123xxxx" and we know all the result from 2. Because 12<26,
    we can make this string either"12"+"3xxxx" or 1+23xxxx which is exactly memo[n]=memo[n-1]+memo[n-2].

    if the String is"32xxxx" memo[n]=memo[n+1]. if there are 0s in the string,
    we should skip it and look at the next character because there is no answer when the string begins with 0.
     */
    public int numDecodingsBottomUpDP( String s ) {
        int n = s.length();
        if (n == 0) return 0;

        int[] memo = new int[n + 1];
        memo[n] = 1;
        memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];

        return memo[0]; //contains number of ways to decode the string
    }
}
