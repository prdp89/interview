package com.interview.codechef.ccdsapfoundation_1.DP.GFG;

public class SumOfSubstringOfNumbers {

    //https://www.geeksforgeeks.org/sum-of-all-substrings-of-a-string-representing-a-number/
    //https://www.hackerrank.com/challenges/sam-and-substrings/editorial
    public static void main( String[] args ) {
        sumOfSubstrings("1234".toCharArray());
    }

    //go through it again, didn't understood properly
    private static void sumOfSubstrings( char[] str ) {
        long out = Character.getNumericValue(str[0]);
        long temp = Character.getNumericValue(str[0]);

        for (int i = 1; i < str.length; i++) {
            temp = temp * 10 + (i + 1) * Character.getNumericValue(str[i]);
            out = out + temp;
        }

        System.out.println(out);
    }
}
