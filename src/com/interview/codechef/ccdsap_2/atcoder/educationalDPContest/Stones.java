package com.interview.codechef.ccdsap_2.atcoder.educationalDPContest;

import java.util.Scanner;

public class Stones {

    //qut : https://atcoder.jp/contests/dp/tasks/dp_k

    private static Boolean dp[];

    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        dp = new Boolean[k + 1];

        System.out.println(canWin(k, a) ? "First" : "Second");
    }

    private static boolean canWin( int k, int[] a ) {

        //if no values present in DB then
        if (dp[k] == null) {

            for (int i : a) {

                //if First player consumes all the stones then no stone left for Second; obviously First wins.
                if (i == k)
                    return dp[k] = true;

                    //if current stone is less than total pile of stones
                else if (i < k) {

                    //consumes/pick stones until no stone left for Second player
                    if (!canWin(k - i, a))
                        return dp[k] = true;
                }
            }

            //THis case will run if all stone pile is consumed and none of above condition if met
            dp[k] = false;
        }
        return dp[k];
    }
}