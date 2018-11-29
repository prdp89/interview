package com.interview.hackerrank.recursion;

public class NestParenthesis {

    public static void main( String[] args ) {
        System.out.println(nestParen("(((()))"));
    }

    //https://codingbat.com/prob/p183174
    private static boolean nestParen( String str ) {

        //simplify version
        return str.length() == 0 || (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') && nestParen(str.substring(1, str.length() - 1));


       /* if (str.length() == 0)
            return true;

        return str.charAt(0) == '(' &&  str.charAt(str.length() - 1) == ')'
                ? nestParen(str.substring(1, str.length() - 1))
                : false;*/
    }

}
