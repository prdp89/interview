package com.interview.hackerrank.recursion;

public class StringClean {

    //https://codingbat.com/prob/p104029
    public static void main( String[] args ) {
        System.out.println(stringClean("abbbcdd"));
    }

    private static String stringClean(String str) {

        if(str.length() < 2)
            return str;

        return str.charAt(0) == str.charAt(1)
                ? stringClean(str.substring(1))
                : str.charAt(0) + stringClean(str.substring(1));
    }
}
