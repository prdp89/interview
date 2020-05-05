package com.interview.leetcode.thirtydaymaychallenge;

public class NumbersComplement {

    //https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3319/
    public static void main( String[] args ) {
        int n = 1;
        System.out.println(findComplement(n));
    }

    //Runtime: 1 ms
    //Memory Usage: 36.4 MB
    private static int findComplement( int num ) {
        String str = Integer.toBinaryString(num);
        char[] arr = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            //char to num: (arr[i] - '0')
            //num to char: (arr[i] - '0') + '0'
            arr[i] = (char) (1 - (arr[i] - '0') + '0');
        }

        return Integer.parseInt(String.valueOf(arr), 2);
    }
}
