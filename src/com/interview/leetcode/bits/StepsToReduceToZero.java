package com.interview.leetcode.bits;

public class StepsToReduceToZero {

    /*
    Given a number s in their binary representation.
    Return the number of steps to reduce it to 0 under the following rules:

    If the current number is even, you have to divide it by 2.

    If the current number is odd, you have to subtract 1 from it.

    It's guaranteed that you can always reach to zero for all testcase
     */
    public static void main( String[] args ) {
        //String s = "011100"; //decimal = 28, op = 7
        String s = "111"; //decimal = 5,  op = 5

        int i, n = s.length();
        int ans = 0;

        for (i = 0; i < n && s.charAt(i) == '0'; i++) ;

        if (i == n) {
            System.out.println(0);
            return;
        }

        //It means if character is 1 : 2 steps needs to reduce
        for (; i < n; i++)
            ans += 1 + (s.charAt(i) == '1' ? 1 : 0);

        System.out.println(ans - 1);
    }
}
