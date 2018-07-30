package com.interview.codingblocks.week6recursion;

public class IncreaseDecreaseNumber {

    private static void decrease( int n ) {

        if (n == 0)
            return;

        //10 will be printed first
        System.out.println(n);

        //then call to method to decrease the number
        decrease(n - 1);
    }

    private static void increase( int n ) {

        if (n == 0)
            return;

        //stack will be filled reverse from 10 .... 1
        increase(n - 1);

        //while popping element from stack, 1 will be printed first.
        System.out.print(n + " ");
    }

    public static void main( String[] args ) {

        increase(10);
        decrease(10);
    }
}
