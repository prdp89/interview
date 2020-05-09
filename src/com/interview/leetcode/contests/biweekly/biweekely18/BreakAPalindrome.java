package com.interview.leetcode.contests.biweekly.biweekely18;

public class BreakAPalindrome {

    //https://leetcode.com/contest/biweekly-contest-18/problems/break-a-palindrome/
    public static void main( String[] args ) {
        String str = "abccba";

        System.out.println(breakPalindrome(str));
    }

    private static String breakPalindrome( String palindrome ) {
        if (palindrome.length() == 1)
            return "";

        char[] arr = palindrome.toCharArray();

        //should check till length / 2
        for (int i = 0; i < palindrome.length() / 2; i++) {
            if (arr[i] != 'a') {
                arr[i] = 'a';
                return new String(arr);
            }
        }

        arr[palindrome.length() - 1] = 'b'; //if all chars are 'a'
        return new String(arr);
    }
}
