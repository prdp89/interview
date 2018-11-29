package com.interview.hackerrank.recursion;

public class CountX {

    //https://codingbat.com/prob/p170371
    public static void main( String[] args ) {
        System.out.println(solve("xyxyzx"));
    }

    private static int solve( String str ) {

        if (str.length() == 0)
            return 0;

        int sum = (str.charAt(str.length() - 1) == 'x' ? 1 : 0) + solve(str.substring(0, str.length() - 1));
        return sum;
    }
}
