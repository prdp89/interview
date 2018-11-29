package com.interview.codingblocks.week9DynamicProgrammming;

import java.util.Arrays;
import java.util.Scanner;

public class DiwaliPuzzle {

    //region Question
    /*

       " DIWALI PUZZLE "
    Its Diwali time and everyone is busy decorating there homes using light bulbs.
    The light bulbs are arranged in a row. Little bob is bored of participating in contests so he decided
    to write 1 for every bulb which is on and 0 for every bulb which is off and creates an array of size equal
    to number of light bulbs.

    Since he is a bright kid he looks at his array and calculates the sum of all the adjacent pairwise
    products and wonders how many such combinations exist. More formally you are given an array of size n
    (consisting of 0 and 1 only) and k = a1a2 + a2a3 + a3a4 + … an-1an.

    You have to find out how many combinations of these light bulbs of size n (on and off) will give the
    sum of products equal to given value k. You have to calculate this value modulo 10^6+3.

    Input Format:
    The first line consists of number of test cases. The second line consists of two values n and k.

    Constraints:
    test cases <= 100 n <= 100 k <= 100

    Output Format
    The number of combinations modulo 10^6+3.

    Sample Input:
    6
    5 3
    10 9
    99 87
    23 34
    66 23
    23 12

    Sample Output:
    2
    1
    185141
    0
    375215
    84498

    For first input : 5 3 (5 light bulbs, output should be 3)
    Possible Configurations : 1 1 1 1 0 (4 bulbs are ON and 1 is OFF) = 1*1 + 1*1 + 1*1 + 1*0 = 3
                              0 1 1 1 1 (4 bulbs are ON and 1 is OFF) = 0*1 + 1*1 + 1*1 + 1*1 = 3

    so 2 config. possible, hence 2 is output.

     */

    //Observation 1: If array :     0 0 1 ..
    //if we fill next element as 1: 0 0 1 1   (then total count will increase to +1) bcz 1*1 pair will contribute to 1.

    //Observation 1: If array :     0 0 1 ..
    //if we fill next element as 1: 0 0 1 0 (then count will not increase) bcz 1*0 pair will not contribute to 1.
    //endregion

    private final static long MOD = 1000003; //taken bcz result be very large
    static long dp[][][] = new long[105][3][105];
    private static int totalBulbs, totalSumOfCombination;

    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);

        totalBulbs = scanner.nextInt();
        totalSumOfCombination = scanner.nextInt();

        // start by both choice with first value either 0 or 1
       // System.out.println(solveRecursive(1, 0, 0) + solveRecursive(1, 1, 0));

        for (long[][] innerRow : dp) {
            for (long[] innerInnerRow : innerRow) {
                Arrays.fill(innerInnerRow, -1);
            }
        }

        System.out.println(solveTopDownDP(1, 0, 0) + solveRecursive(1, 1, 0) % MOD);
    }

    private static long solveRecursive( long index, long prev, long count ) {

        if (index >= totalBulbs) {

            //if index reaches end and count == required combination, return 1 else 0
            if (count == totalSumOfCombination)
                return 1;
            return 0;
        }

        long ans = 0;

        //if prev array value is = 1
        if (prev == 1) //try putting next value as 1, increase count.
            ans = ans + solveRecursive(index + 1, 1, count + 1);

        else //if prev = 0, try putting next value as 1, doesn't increase count.
            ans = ans + solveRecursive(index + 1, 1, count);

        //Regardless of previous value; Try putting next value as 0, count doesn't increases.
        ans = ans + solveRecursive(index + 1, 0, count);

        return ans;
    }

    //if function = solveTopDownDP(index, prev, count) then dp array :
    // dp array =   dp[         100,       2,          100  ]
    //                           N,  choices(0 or 1),   k
    private static long solveTopDownDP( long index, long prev, long count ) {

        if (index >= totalBulbs) {

            //if index reaches end and count == required combination, return 1 else 0
            if (count == totalSumOfCombination)
                return 1;
            return 0;
        }

        //Top Down dp
        if (dp[(int) index][(int) prev][(int) count] != -1) {
            return dp[(int) index][(int) prev][(int) count];
        }

        long ans = 0;

        //if prev array value is = 1
        if (prev == 1) //try putting next value as 1, increase count.
            ans = ans + solveTopDownDP(index + 1, 1, count + 1);

        else //if prev = 0, try putting next value as 1, doesn't increase count.
            ans = ans + solveTopDownDP(index + 1, 1, count);

        ans %= MOD;

        //Regardless of previous value; Try putting next value as 0, count doesn't increases.
        ans = ans + solveTopDownDP(index + 1, 0, count);
        ans %= MOD;

        return dp[(int) index][(int) prev][(int) count] = ans;
    }
}
