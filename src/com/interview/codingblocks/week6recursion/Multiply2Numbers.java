package com.interview.codingblocks.week6recursion;

public class Multiply2Numbers {

    //Multiply 2 numbers without using * operator
    private static int solve( int a, int b ) {

        if (b == 1)
            return a;

        int sum = a + solve(a, b - 1);

        return sum;

    }

    public static void main( String[] args ) {
        System.out.println(solve(6, 3));
    }
}
