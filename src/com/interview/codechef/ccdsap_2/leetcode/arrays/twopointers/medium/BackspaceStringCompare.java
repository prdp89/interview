package com.interview.codechef.ccdsap_2.leetcode.arrays.twopointers.medium;

public class BackspaceStringCompare {

    //https://leetcode.com/problems/backspace-string-compare/
    public static void main( String[] args ) {
        String s = "ab#c", t = "ad#c";
        //String s = "ab##", t = "c#d#";

        //String s = "a##c", t = "#a#c";

        //String s = "a#c", t = "b";

       // String s = "a##c", t = "#a#c";

        System.out.println(backspaceCompareBruteForce(s, t));
    }

    //Runtime 1 MS ; Memory 34.6MB ; Top 76.09% submission
    private static boolean backspaceCompareBruteForce( String S, String T ) {

        StringBuilder sb = new StringBuilder();

        int i = 1;

        //append first char here
        sb.append(S.charAt(0));

        //delete last char from sb if # occurs
        while (i < S.length()) {

            if (S.charAt(i) == '#') {
                if (sb.length() > 0)
                    sb.deleteCharAt(sb.length() - 1);
            } else
                sb.append(S.charAt(i));

            i++;
        }

        S = sb.toString();


        i = 1;
        sb = new StringBuilder();

        sb.append(T.charAt(0));

        while (i < T.length()) {

            if (T.charAt(i) == '#') {
                if (sb.length() > 0)
                    sb.deleteCharAt(sb.length() - 1);
            } else
                sb.append(T.charAt(i));

            i++;
        }

        //remove character # from S and T strings
        i = 0;
        while (i < sb.length()) {
            if (sb.charAt(i) == '#') {
                sb.deleteCharAt(i);
                i++;
            }

            i++;
        }

        T = sb.toString();

        i = 0;
        sb = new StringBuilder(S);
        while (i < sb.length()) {
            if (sb.charAt(i) == '#') {
                sb.deleteCharAt(i);
                i++;
            }
            i++;
        }

        return T.equals(sb.toString());
    }
}
