package com.interview.codingblocks.week6recursion;

public class StringToIntRec {

    //need static global variable to persist value.
    private static int x = 0;

    private static int solve( String str) {

        if (str.length() == 1) {
            x = (x * 10) + Integer.parseInt(str.substring(0, 1));
            return x;
        } else {

            //int number = result + ((str[start] - '0') * 10) + ((start <= len - 2) ? str[start + 1] - '0' : 0);

            x = x * 10 + (Integer.parseInt(str.substring(0, 1)));

            return solve(str.substring(1, str.length()));
        }
    }

    public static void main( String[] args ) {
        //    System.out.println(Integer.parseInt("1"));
        System.out.println(solve("123"));
    }
}
