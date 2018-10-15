package com.interview.codingblocks.week9DynamicProgrammming;

import java.util.HashMap;
import java.util.Scanner;

public class CoinChangeTotalWays {

    /*
    Input:
    3
    1 2 3
    4
    4
    2 5 3 6
    10

    Output:
    case 1 : For N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
             So output should be 4.

    case 2 : For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
             So the output should be 5.
     */
    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        int money = scanner.nextInt();

        long startTime = System.nanoTime();

        System.out.println(solveRecursive(coins, money, 0));

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Time Recursive: " + totalTime);

        //-----------------------------------------------------------------------------

        long startTimeMemoization = System.nanoTime();

        System.out.println(solveTopDownDP(coins, money, 0, new HashMap<>()));

        long endTimeMemoization = System.nanoTime();
        long totalTimeMemoization = endTimeMemoization - startTimeMemoization;
        System.out.println("Time Top Down DP : " + totalTimeMemoization);

        //----------------------------------------------------------------------------------

        long startBottomupDP = System.nanoTime();

        System.out.println(solveBottomUpDP(coins, money));

        long endTimeBottomUP = System.nanoTime();
        long totalTimeBottomUp = endTimeBottomUP - startBottomupDP;
        System.out.println("Time Bottom Up DP : " + totalTimeBottomUp);
    }

    //Time complexity : O ( 2 ^ N )
    private static long solveRecursive( int[] coins, int money, int index ) {

        //if no Money then 1 way to make Money.
        if (money == 0)
            return 1;

        //if all coins have been used
        if (index >= coins.length)
            return 0;

        int amountWithCoin = 0;
        long ways = 0;

        while (amountWithCoin <= money) {

            int remainingMoney = money - amountWithCoin;
            ways += solveRecursive(coins, remainingMoney, index + 1);

            //include the current coin in amount.
            amountWithCoin += coins[index];
        }

        return ways;
    }

    //Time complexity : O ( M * N )
    private static long solveTopDownDP( int[] coins, int money, int index, HashMap<String, Long> map ) {

        //if no Money then 1 way to make Money.
        if (money == 0)
            return 1;

        //if all coins have been used
        if (index >= coins.length)
            return 0;

        //separating Total Money with Coins Index.
        String key = money + "-" + index;
        if (map.containsKey(key))
            return map.get(key);

        int amountWithCoin = 0;
        long ways = 0;

        while (amountWithCoin <= money) {

            int remainingMoney = money - amountWithCoin;
            ways += solveTopDownDP(coins, remainingMoney, index + 1, map);
            amountWithCoin += coins[index];

        }

        //put ways in MAP for memoization.
        map.put(key, ways);

        return ways;
    }

    //Using 1D array: https://www.youtube.com/watch?v=jaNZ83Q3QGc
    //For Include-exclude principle : https://www.youtube.com/watch?v=PafJOaMzstY&t=1171s

    //THis problem is also similar: min coins : https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/CoinChangingMinimumCoin.java

    private static long solveBottomUpDP( int[] coins, int money ) {

        long dp[] = new long[money + 1];

        //number of ways to make zero coin is 1
        dp[0] = 1;

        //Iterating for all the coins to make combinations.
        for (int coin : coins) {

            //pick up the First coin from Coins : check number of ways to build amount (i) from coin[index]
            for (int i = 1; i < dp.length; i++) {

                if (i >= coin) {

                    //If we have coin = 1 and amount (i) = 3 :
                    //So number of ways to make amount = 3 using coin = 1 is:
                    //ans = number of ways to make amount (i) + (num. of ways to make amount - current_coin)
                    // ans = 1 + dp[3 - 1] = answer.
                    dp[i] += dp[i - coin];

                    // printDPArrayForEachCoin(dp);
                }
            }
        }

        return dp[money];
    }

    private static void printDPArrayForEachCoin( long[] dp ) {
        for (long aDp : dp) {
            System.out.print(aDp + " ");
        }
        System.out.println("\n");
    }
}
