package com.interview.codechef.ccdsap_2.leetcode.contests.contest152;

import java.util.ArrayList;
import java.util.List;

public class CanMakePalindrome {

    public static void main( String[] args ) {
        int[][] queries = {
                {3, 3, 0},
                {1, 2, 0},
                {0, 3, 1},
                {0, 3, 2},
                {0, 4, 1}
        };

        canMakePaliQueries("abcda", queries).forEach(System.out::println);

        /*int[][] queries = {
                {3, 3, 1},
                {3, 4, 2},
                {2, 2, 1},
                {3, 4, 2}
        };

        canMakePaliQueries("shezu", queries).forEach(System.out::println);*/
    }

    //ref:https://www.geeksforgeeks.org/minimum-number-of-characters-to-be-replaced-to-make-a-given-string-palindrome/
    private static int change( String s ) {

        // Finding the length of the string
        int n = s.length();

        // To store the number of replacement operations
        int cc = 0;

        for (int i = 0; i < n / 2; i++) {

            // If the characters at location
            // i and n-i-1 are same then
            // no change is required
            if (s.charAt(i) == s.charAt(n - i - 1))
                continue;

            // Counting one change operation
            cc += 1;

            // Changing the character with higher
            // ascii value with lower ascii value
            if (s.charAt(i) < s.charAt(n - i - 1))
                s = s.replace(s.charAt(n - i - 1), s.charAt(i));
            else
                s = s.replace(s.charAt(n - 1), s.charAt(n - i - 1));
        }
        return cc;
    }

    //21 / 30 test cases passed.
    private static List<Boolean> canMakePaliQueries( String s, int[][] queries ) {

        List<Boolean> booleanList = new ArrayList<>();
        for (int[] arr : queries) {

            String str = s.substring(arr[0], arr[1] + 1);

            if (str.length() == 1) {
                booleanList.add(true);
                continue;
            }

            int minInsertion = change(str);
            booleanList.add(arr[2] >= minInsertion);
        }

        return booleanList;
    }
}
