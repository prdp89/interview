package com.interview.codingblocks.week6recursion;

import java.util.Date;

public class Palindrome {

    //https://www.geeksforgeeks.org/check-if-a-number-is-palindrome/
    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        String str = "aaada";

       // System.out.println(palindrome(str.toCharArray(), 0, str.length() - 1));

        int n = 2121212;
        System.out.println(System.currentTimeMillis());
        System.out.println(isPalindrome(n));
        System.out.println(System.currentTimeMillis());
        System.out.println(palindromeOfNumber(n, 0) == n);
        System.out.println(System.currentTimeMillis());
    }

    private static int palindromeOfNumber( int num, int reverse ) {

        if (num % 10 == 0)
            return reverse;

        return palindromeOfNumber(num / 10, num % 10 + reverse * 10);
    }

    private static boolean palindrome( char[] str, int low, int high ) {

        if (low >= high)
            return true;

        return str[low++] == str[high--] && palindrome(str, low, high);
    }


    //Ultra fast program by Mitash :D :P
    private static boolean isPalindrome( int num ) {
        int remainder, reverse = 0, tempNum = num;
        while (tempNum > 0) {
            remainder = tempNum % 10;
            tempNum = tempNum / 10;
            reverse = (reverse * 10) + remainder;
        }
        return reverse == num;
    }
}
