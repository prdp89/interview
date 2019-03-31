package com.interview.codingblocks.week9DynamicProgrammming;

import java.util.Arrays;
import java.util.Scanner;

public class ValentineMagic {

    /*
    It's valentine day, every boy want to be in pair with a girl. But boys have advantage that they are less in number.
    Every boy have certain Chocolates and girl have candies.

    Now being the anchor, we want to pair Boy with Girl such that Sum of Absolute difference between Boy's chocolate and girls candy
    in a pair should be minimized.

    1<=N<=5000
    1<=M<=5000

    M>=N
    1<=chocolates <= 10^6
    1<=candies <= 10^6

    First line contain N boys and M girls
    Next line contain chocolates
    Next line contain candies

    2 5
    4 5
    1 2 3 4 5

    Boys have : {4,5} chocolates
    Girls have : {1,2,3,4,5} candies

    To minimize the diff., we can pair : {4,4} and {5,5} and,
    Absolute sum of difference : 4-4 + 5-5 => 0
     */

    private static long n, m;
    private static long chocolates[] = new long[5005];
    private static long candies[] = new long[5005];
    private static long dp[][] = new long[5005][5005];

    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);

        //Number of boys and girls
        n = scanner.nextInt();
        m = scanner.nextInt();

        chocolates = new long[(int) n];
        candies = new long[(int) m];

        for (int i = 0; i < n; i++)
            chocolates[i] = scanner.nextInt();

        for (int i = 0; i < m; i++)
            candies[i] = scanner.nextInt();

        //sort the chocolates and candies to find out minimum absolute difference
        Arrays.sort(chocolates);
        Arrays.sort(candies);

        for (long[] row : dp)
            Arrays.fill(row, -1);

        long ans = minAbsoulteDiff(0, 0);
        System.out.println(ans);
    }

    //i: index for N boy
    //j: index for M girls
    //For this problem we are assuming boy should be paired with a girl

    //Time complexity = O ( M * N )
    private static long minAbsoulteDiff( int i, int j ) {

        if (i == n) {
            //we have paired all the boys
            return 0;
        }

        if (j == m) {
            //we have rejected a-lot of girls, and no girl is left for boys
            return Integer.MAX_VALUE;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        //Two case will happen:

        //1.) we try to pair every boy with every girl and finding absolute difference
        long ops = Math.abs(chocolates[i] - candies[j]) + minAbsoulteDiff(i + 1, j + 1); //by accepting jth girl

        //2.) we don't pair ith boy with jth girl; And we try to traverse the next index of girl array
        long ops1 = minAbsoulteDiff(i, j + 1); //we have rejected the jth girl

        return dp[i][j] = Math.min(ops, ops1);
    }
}
