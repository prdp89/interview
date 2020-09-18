package com.interview.codechef.ccdsapfoundation_1.DP.educativeIO;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CountPalindromicSubstrings {

    //https://leetcode.com/problems/palindromic-substrings/
    //https://www.geeksforgeeks.org/count-palindrome-sub-strings-string/
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            String str = scanner.next();

            System.out.println(checkPalindrome(str));

            System.out.println(palindromes(str).size());
        }
    }

    private static Set<String> palindromes( final String input ) {

        final Set<String> result = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {

            // expanding even length palindromes:
            expandPalindromes(result, input, i, i + 1);

            // expanding odd length palindromes:
            expandPalindromes(result, input, i, i);
        }
        return result;
    }

    private static void expandPalindromes( final Set<String> result, final String s, int i, int j ) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {

            if (s.substring(i, j + 1).length() > 1) //don't add 1 length string
                result.add(s.substring(i, j + 1));

            i--;
            j++;
        }
    }

    //THis logic is also good but complexity is greater than O(N^2)
    private static int checkPalindrome( String s ) {
        int L = s.length();

        int counter = 0;
        long startTime = System.currentTimeMillis();

        Set<String> hs = new HashSet<>();

        // add elements to the hash set
        //System.out.println("Possible substrings: ");

        for (int i = 0; i < L; ++i) {

            //If I==1 : pair of length 1 will be picked
            //If I==2 : pair of length 2 will be picked
            for (int j = 0; j < (L - i); ++j) {
                String subs = s.substring(j, i + j + 1);
                counter++;

                //  System.out.println(subs);

                if (isPalindrome(subs) && subs.length() > 1) //dont add 1 length string
                    hs.add(subs);
            }
        }

        /*
        System.out.println("Total possible substrings are " + counter);
        System.out.println("Total palindromic substrings are " + hs.size());
        System.out.println("Possible palindromic substrings: " + hs.toString());

        long endTime = System.currentTimeMillis();

        System.out.println("It took " + (endTime - startTime) + " milliseconds");*/

        return hs.size();
    }

    private static boolean isPalindrome( String s ) {

        if (s.length() == 0 || s.length() == 1)
            return true;

        if (s.charAt(0) == s.charAt(s.length() - 1))
            return isPalindrome(s.substring(1, s.length() - 1));

        return false;
    }
}
