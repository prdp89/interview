package com.interview.leetcode.contests.biweekly.biweekely20;

public class CountAllValidPickup {

    //https://leetcode.com/contest/biweekly-contest-20/problems/count-all-valid-pickup-and-delivery-options/
    public static void main( String[] args ) {
        int n = 2;
        System.out.println(countOrders(n));
    }

    /*
    Assume we have already n - 1 pairs, now we need to insert the nth pair.
    To insert the first element, there are n * 2 - 1 choices of position。
    To insert the second element, there are n * 2 choices of position。

    So there are (n * 2 - 1) * n * 2 permutations.

    Considering that delivery(i) is always after of pickup(i), we need to divide 2.
    So it's (n * 2 - 1) * n.
     */
    private static int countOrders( int n ) {

        long res = 1, mod = (long) (10e9) + 7;

        for (int i = 1; i <= n; i++) {
            res = res * (i * 2 - 1) * i % mod;
        }

        return (int) res;
    }
}
