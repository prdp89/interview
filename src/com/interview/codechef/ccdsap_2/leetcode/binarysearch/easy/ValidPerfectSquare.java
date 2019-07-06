package com.interview.codechef.ccdsap_2.leetcode.binarysearch.easy;

public class ValidPerfectSquare {

    //https://leetcode.com/problems/valid-perfect-square/
    public static void main( String[] args ) {
        int n = 39;

        solve(n);
    }

    //Better complexity : O(LogN)
    private static void solve( int n ) {

        int start = 0, end = n;

        while (start <= end) {

            long mid = (start + end) / 2;

            if (mid * mid == n) {
                System.out.println(true);
                return;
            } else if (mid * mid > n) {
                end = (int) mid - 1;
            } else {
                start = (int) mid + 1;
            }
        }

        System.out.println(false);
    }

    //A square number is summation of 1 + 3 + 5 + 7....N
   /*       1 = 1
            4 = 1 + 3
            9 = 1 + 3 + 5
            16 = 1 + 3 + 5 + 7
            25 = 1 + 3 + 5 + 7 + 9
            36 = 1 + 3 + 5 + 7 + 9 + 11
   */
    //If we subtract 1 or 1 + 3 or 1 + 3 + 5 if number turns zero then it is a perfect square
    private static boolean isPerfectSquare( int num ) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

}
