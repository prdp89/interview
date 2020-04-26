package com.interview.codechef.ccdsap_2.leetcode.binarysearch.easy;

public class ArrangingCoins {

    //https:www.leetcode.com/problems/arranging-coins/
    public static void main( String[] args ) {
        int n = 8;

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; ) {

            max = Math.max(max, i);
            n -= i;
            i++;
        }

        System.out.println(max);
    }

    //A mathematical formula exists :
    //(x * ( x + 1)) / 2 <= n : for steps N we are looking if ith step 1 + 2 + 3...<=N
    //Therefore x = 1 / 2 * (-sqrt(8 * n + 1)-1)` (Inapplicable) or `x = 1 / 2 * (sqrt(8 * n + 1)-1)

    //Time complexity O(Log N)
    private static int arrangeCoins( int n ) {
        return (int) ((-1 + Math.sqrt(1 + 8 * (long) n)) / 2);
    }

}
