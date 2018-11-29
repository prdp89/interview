package com.interview.hackerrank.recursion;

public class CountPairs {

    //https://codingbat.com/prob/p154048
    public static void main( String[] args ) {
        System.out.println(countPairs("axax"));
    }

    private static int countPairs( String str ) {

        if (str.length() < 3)
            return 0;

        int sum = str.charAt(0) == str.charAt(2)
                ? 1 + countPairs(str.substring(1))
                : countPairs(str.substring(1));
        return sum;
    }
}
