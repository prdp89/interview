package com.interview.hackerrank.recursion;

public class Triangle {

    //https://codingbat.com/prob/p194781

    public static void main( String[] args ) {
        System.out.println(triangle(2));
    }

    private static int triangle( int rows ) {

        if (rows == 0)
            return 0;

        int sum = rows + triangle(rows - 1);
        return sum;

    }
}
