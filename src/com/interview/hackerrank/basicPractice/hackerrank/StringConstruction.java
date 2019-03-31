package com.interview.hackerrank.basicPractice.hackerrank;

public class StringConstruction {

    //https://www.hackerrank.com/challenges/string-construction/problem
    public static void main( String[] args ) {
        System.out.println(solve("abcd"));
    }

    private static int solve( String str ) {
        int[] arr = new int[26];

        for (Character c : str.toCharArray()) {
            arr[c - 97]++;
            //System.out.println(val);
        }

        int result = 0;
        for (int val : arr) {
            if (val >= 1)
                result++;
        }

        return result;
    }

    private static long solveOPtimal(String str){
        return str.chars().distinct().count();
    }
}
