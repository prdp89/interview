package com.interview.hackerrank.recursion;

public class Count7 {

    //https://codingbat.com/prob/p101409
    public static void main( String[] args ) {
        System.out.println(solve(123));
    }

    private static int solve( int num ) {

        if (num == 0)
            return 0;

        int sum = (num % 10 == 7 ? 1 : 0) + solve(num / 10);
        return sum;
    }
}
