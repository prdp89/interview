package com.interview.codechef.ccdsap_2.leetcode.dp.easy;

public class DivisorGame {

    //https://leetcode.com/problems/divisor-game
    public static void main( String[] args ) {
        System.out.println(divisorGame(3));
    }

    /*
    prove it by (consider for 1 alice lose):

    if Alice will lose for N, then Alice will must win for N+1, since Alice can first just make N decrease 1.

    let's check the inference:
    first N = 1, Alice lose. then Alice will must win for 2.
    if N = 3, since all even number(2) smaller than 3 will leads Alice win, so Alice will lose for 3
    3 lose -> 4 win
    all even number(2,4) smaller than 5 will leads Alice win, so Alice will lose for 5
     */
    private static boolean divisorGame( int N ) {
        return N % 2 == 0;
    }
}
