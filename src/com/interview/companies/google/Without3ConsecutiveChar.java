package com.interview.companies.google;

public class Without3ConsecutiveChar {

    //https://leetcode.com/discuss/interview-question/358268/google-mock-interview-string-without-3-identical-consecutive-letters

    /*
    Given a string S consisting of N letters a and b. In one move you can replace one letter by the other (a by b or b by a).

    Write a function solution that given such a string S, returns the minimum number of moves required to obtain a string containing
    no instances of three identical consecutive letters.
    */

    /*
    Example 1:

    Input: "baaaaa"
    Output: 1
    Explanation: The string without three identical consecutive letters which can be obtained is one move is "baabaa".
     */
    public static void main( String[] args ) {
        System.out.println(solve("baaaaaa"));
    }

    private static int solve( String str ) {
        int res = 0;
        for (int i = 1; i < str.length(); i++) {

            int runningLength = 1;
            while (i < str.length() && str.charAt(i) == str.charAt(i - 1)) {
                //how many chars are same from this point..
                runningLength++;
                i++;
            }

            //if next 3 chars are same then 1 way to replace it. So divide by 3 returns number of replacement
            res = res + runningLength / 3;
        }

        return res;
    }
}
