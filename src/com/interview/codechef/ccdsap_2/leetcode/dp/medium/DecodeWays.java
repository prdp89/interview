package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.Arrays;

public class DecodeWays {

    //https://leetcode.com/problems/decode-ways/
    public static void main( String[] args ) {
        System.out.println(numDecodings("226"));

        System.out.println(decodeWaysBottomUp("226"));
    }

    //ref : https://leetcode.com/problems/decode-ways/discuss/30358/Java-clean-DP-solution-with-explanation
    private static int decodeWaysBottomUp( String s ) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        /*
        dp[0] means an empty string will have one way to decode, dp[1] means the way to decode a string of size 1.
        Then check one digit and two digit combination and save the results along the way.
         */
        int[] dp = new int[s.length() + 1];

        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        //eg: 226
        //If i=2, dp[2] tells number of ways to decode string of length 2 : first = 2 second : 22
        //If i=3, dp[3] tells number of ways to decode string of length 3 : first = 2 second : 22 {bcz we can split the string at max 2 parts only}

        for (int i = 2; i <= s.length(); i++) {

            //first is always of single digit
            int first = Integer.valueOf(s.substring(i - 1, i));

            //second is always of 2 digits
            int second = Integer.valueOf(s.substring(i - 2, i));

            //if both : the first and second strings are valid then add it to the current length.
            if (first >= 1 && first <= 9) {
                //adding previous length to get total number of ways..
                dp[i] += dp[i - 1];
            }

            if (second >= 10 && second <= 26)
                dp[i] += dp[i - 2];
        }

        return dp[dp.length - 1];
    }


    //https://leetcode.com/problems/decode-ways/discuss/217193/5ms-SLOPPY-Java-Solution-Using-Recursion-and-Memoization
    private static int numDecodings( String s, int decodePointer, int[] previousAnswers ) {

	/*
        If our decoding pointer out of bounds then we know that we have
		exhausted our ability to decode the string
	*/
        if (decodePointer >= s.length()) {
            return 1;
        }

        if (previousAnswers[decodePointer] > -1) {
            return previousAnswers[decodePointer];
        }

        int totalWaysFromHere = 0;

        //we can only divide the string in two ways :
        //- single character and - Multiple character
        if (decodePointer + 1 <= s.length()) {
            String firstWay = s.substring(decodePointer, decodePointer + 1); // single character decoding
            if (isValid(firstWay)) {
                totalWaysFromHere += numDecodings(s, decodePointer + 1, previousAnswers);
            }
        }

        //2nd way of splitting string
        if (decodePointer + 2 <= s.length()) {
            String secondWay = s.substring(decodePointer, decodePointer + 2); // 2 character decoding
            if (isValid(secondWay)) {
            /*
                If this is a valid decoding then recurse on it since it is ONE valid way to decode
				a piece of the string off. If it is INVALID we will not factor this way of decoing
				in and the path in the "tree" of recursion is cut short
			*/
                totalWaysFromHere += numDecodings(s, decodePointer + 2, previousAnswers);
            }
        }

        previousAnswers[decodePointer] = totalWaysFromHere;

        return previousAnswers[decodePointer]; // The answer to this subproblem
    }

    private static boolean isValid( String s ) {

        if (s.length() == 0) {
            return false;
        }

        if (s.charAt(0) == '0') {
            return false;
        }

        int value = Integer.parseInt(s);

        return value >= 1 && value <= 26;
    }

    private static int numDecodings( String s ) {
        int[] previousAnswers = new int[s.length() + 1];
        Arrays.fill(previousAnswers, -1);

        return numDecodings(s, 0, previousAnswers);
    }
}
