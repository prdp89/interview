package com.interview.codechef.ccdsap_2.leetcode.companies.amazon;

public class ReverseWordsStringII {

    //https://www.programcreek.com/2014/05/leetcode-reverse-words-in-a-string-ii-java
    //https://leetcode.com/articles/reverse-words-in-a-string-ii/
    public static void main( String[] args ) {
        char[] str = "the sky is blue".toCharArray();

        reverseWords(str);

        System.out.println(str);
    }

    private static void reverse( char[] s, int left, int right ) {
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }

    private static void reverseEachWord( char[] s ) {
        int n = s.length;
        int start = 0, end = 0;

        while (start < n) {
            // go to the end of the word
            while (end < n && s[end] != ' ')
                ++end;

            // reverse the word
            reverse(s, start, end - 1);

            // move to the next word
            start = end + 1;
            ++end;
        }
    }

    private static void reverseWords( char[] s ) {
        // reverse the whole string
        reverse(s, 0, s.length - 1);

        // reverse each word
        reverseEachWord(s);
    }
}
