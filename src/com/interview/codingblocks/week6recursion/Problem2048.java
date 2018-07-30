package com.interview.codingblocks.week6recursion;

//Given a number '2048' , convert it to English equivalent as TWO ZERO FOUR EIGHT
public class Problem2048 {

    private static String spelling [] = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
    private static void solve(int number){

        if(number == 0)
            return;

        //IF we use SOUT here, then it print in reverse order
        // System.out.println(spelling[number % 10]);

        solve(number/10);

        System.out.println(spelling[number % 10]);

    }

    public static void main( String[] args ) {
        solve(5112);
    }
}
