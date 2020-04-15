package com.interview.leetcode.thirtydayschallenge;

public class HappyNumbers {

    //https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3284/
    public static void main( String[] args ) {
        int n = 19;

        System.out.println(isHappy(n));
    }

    private static boolean isHappy( int n ) {

        if (n > 10) {

        }

        while (n != 1) {

            int sum = 0;
            while (n != 0) {
                sum = sum + (int) Math.pow(n % 10, 2);
                n = n / 10;
            }

            n = sum;

            if (n < 10)
                break;
        }

        return n == 1;
    }
}
