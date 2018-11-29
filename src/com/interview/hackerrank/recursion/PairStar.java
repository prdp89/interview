package com.interview.hackerrank.recursion;

public class PairStar {

    //https://codingbat.com/prob/p158175
    public static void main( String[] args ) {
        System.out.println(pairStar("xxyy"));
    }

    private static String pairStar(String str) {

        if(str.equals("") )
            return "";

        if(str.length() < 2)
            return str.charAt(0) + "";

        if(str.charAt(0) == str.charAt(1))
            return str.charAt(0) + "*" + pairStar(str.substring(1));

        return str.charAt(0) + pairStar(str.substring(1));
    }

}
