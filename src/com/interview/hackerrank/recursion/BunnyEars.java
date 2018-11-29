package com.interview.hackerrank.recursion;

public class BunnyEars {

    //https://codingbat.com/prob/p107330
    public static void main( String[] args ) {
        System.out.println(bunnyEars(2));
    }

    private static int bunnyEars( int num ) {

        if (num == 0)
            return 0;

        int sum = (num % 2 == 0 ? 3 : 2) + bunnyEars(num - 1);
        return sum;
    }
}
