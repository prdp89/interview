package com.interview.hackerrank.recursion;

public class NoX {

    //https://codingbat.com/prob/p118230
    public static void main( String[] args ) {
        System.out.println(noX("xx"));
    }

    private static String noX(String str) {

        if(str.length() == 0)
            return "";

       /* return str.charAt(str.length()-1) != 'x'
                ? str.charAt(str.length()-1) + noX(str.substring(0, str.length()-1))
                : noX(str.substring(0, str.length()-1));*/

       return str.charAt(0) != 'x'
               ? str.charAt(0) + noX(str.substring(1))
               : noX(str.substring(1));
    }
}
