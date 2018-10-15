package com.interview.hackerrank.basicPractice;

public class Pangrams {

    //https://www.hackerrank.com/challenges/pangrams/problem
    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {

        char[] s = "We promptly judged antique ivory buckles for the next prize".toLowerCase().toCharArray();

        int[] arr = new int[26];

        for (int i = 0; i < s.length; i++) {

            if (s[i] != ' ')
                arr[(int) s[i] - 97]++;
        }

        for (int num : arr) {
            if (num == 0) {
                System.out.println("not pangram");
                return;
            }
        }

        System.out.println("pangram");
    }
}
