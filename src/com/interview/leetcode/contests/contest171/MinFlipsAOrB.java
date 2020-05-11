package com.interview.leetcode.contests.contest171;

public class MinFlipsAOrB {

    //https://leetcode.com/contest/weekly-contest-171/problems/minimum-flips-to-make-a-or-b-equal-to-c/
    public static void main( String[] args ) {
        int a = 1;
        int b = 2;
        int c = 3;

        System.out.println(minFlips(a, b, c));

        System.out.println(minFlipsOptimized(a, b, c));
    }

    private static int minFlipsOptimized( int a, int b, int c ) {
        int res = 0;

        while (a != 0 || b != 0 || c != 0) {
            int A = a & 1; //if op is 1 then number if ODD
            int B = b & 1;
            int C = c & 1;

            //compare this logic this your's below logic: relatable :)
            //if C is ODD and both NUMS are EVEN
            if (C == 1 && A == 0 && B == 0) {
                res++;
            } else if (C == 0) { //if C is even
                if (A == 1 && B == 1) { //if both are ODD
                    res += 2;
                } else if (A == 1 || B == 1) {
                    res++;
                }
            }

            a = a >> 1; //equals to a/2 or a/2^b
            b = b >> 1;
            c = c >> 1;
        }

        return res;
    }

    /*64 / 64 test cases passed.
            Status: Accepted
    Runtime: 1 ms
    Memory Usage: 37.9 MB*/
    private static int minFlips( int a, int b, int c ) {

        if (a == b && b == c)
            return 0;

        StringBuilder aStr = new StringBuilder(Integer.toBinaryString(a));
        StringBuilder bStr = new StringBuilder(Integer.toBinaryString(b));
        StringBuilder cStr = new StringBuilder(Integer.toBinaryString(c));

        int max = Math.max(cStr.length(), Math.max(aStr.length(), bStr.length()));

        if (max - aStr.length() > 0)
            appendZero(aStr, max - aStr.length());
        if (max - bStr.length() > 0)
            appendZero(bStr, max - bStr.length());
        if (max - cStr.length() > 0)
            appendZero(cStr, max - cStr.length());

        int min = 0;
        for (int i = 0; i < cStr.length(); i++) {
            char cChar = cStr.charAt(i);

            if (cChar == '0') {
                if (bStr.charAt(i) == aStr.charAt(i) && bStr.charAt(i) == '1')
                    min += 2;
                else if (bStr.charAt(i) != aStr.charAt(i))
                    min++;
            } else if (cChar == '1') {
                if (bStr.charAt(i) == aStr.charAt(i) && bStr.charAt(i) == '0')
                    min++;
                /*else if (bStr.charAt(i) == aStr.charAt(i) && bStr.charAt(i) == '1')
                    min += 2;*/
            }
        }

        return min;
    }

    private static void appendZero( StringBuilder aStr, int len ) {
        while (len-- > 0) {
            aStr.insert(0, '0');
        }
    }
}
