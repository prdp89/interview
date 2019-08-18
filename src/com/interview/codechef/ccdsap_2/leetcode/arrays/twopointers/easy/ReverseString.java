package com.interview.codechef.ccdsap_2.leetcode.arrays.twopointers.easy;

import java.util.Arrays;

public class ReverseString {

    //https://leetcode.com/problems/reverse-string/
    public static void main( String[] args ) {
        //char[] s = {'h', 'e', 'l', 'l', 'o'};
        char[] s = {'H', 'a', 'n', 'n', 'a', 'h'};

        solveTry(s);
    }

    private static void solveTry( char[] s ) {

        int start = 0, end = s.length - 1;
        while (start <= end) {

            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }

        System.out.println(Arrays.toString(s));
    }
}
