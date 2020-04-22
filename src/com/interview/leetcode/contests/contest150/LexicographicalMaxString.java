package com.interview.leetcode.contests.contest150;

public class LexicographicalMaxString {

    //https://leetcode.com/problems/last-substring-in-lexicographical-order/
    public static void main( String[] args ) {
        System.out.println(lastSubstring("abab"));
    }

    private static String lastSubstring( String str ) {
        String mx = "";
        char cur = 'a';

        for (int i = 0; i < str.length(); i++) {

            //The result is a negative integer if this {mx} object lexicographically precedes the argument {str.substring} string.
            //The result is zero if the strings are equal;
            if (str.charAt(i) >= cur && mx.compareTo(str.substring(i)) <= 0) { // the first letter of substring matters,
                cur = str.charAt(i);
                mx = str.substring(i);  // for example, "tabc" is lexicographically larger than "tab"
            }

            while (i != str.length() - 1 && str.charAt(i) == str.charAt(i + 1))
                i++;  // get rid of continuous repeating letters
        }
        return mx;
    }
}
