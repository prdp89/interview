package com.interview.leetcode.contests._new_weekely.weekely201;

public class MakeStringGreat {

    //https://leetcode.com/contest/weekly-contest-201/problems/make-the-string-great/
    public static void main( String[] args ) {
        System.out.println(makeGood("s"));
    }

    //yayy solved it :) Runtime: 2 ms
    private static String makeGood( String s ) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;

        while (i + 1 <= sb.length()) {
            if (i > 0 && sb.charAt(i - 1) != sb.charAt(i) && Character.toLowerCase(sb.charAt(i - 1)) == Character.toLowerCase(sb.charAt(i))) {
                sb.delete(i - 1, i + 1);
                i -= 2;
            }

            i++;
        }

        return sb.toString();
    }
}
