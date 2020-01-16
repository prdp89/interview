package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChangeMinCoins {

    //https://leetcode.com/problems/coin-change/
    public static void main( String[] args ) {
        int[] coins = {1, 2, 5};
        int amount = 11; //op : 3 {5, 5, 1}

      /*  int amount = 285;
        int coins[] = {384, 324, 196, 481};*/

        Map<Integer, Integer> map = new HashMap<>();

        if (coins.length == 1 && amount > coins[0] && amount % coins[0] != 0) {
            System.out.println(-1);
            return;
        }

        if (coins.length == 1 && amount < coins[0] && amount > 0) {
            System.out.println(-1);
            return;
        } else if (coins.length == 1 && amount < coins[0]) {
            System.out.println(0);
            return;
        }

        int result = recurse(coins, amount, map);
        if (map.containsKey(amount) && map.get(amount) == Integer.MAX_VALUE)
            result = -1;
        System.out.println(result);


        System.out.println("Botton_up :" + coinChangeBottonUp(coins, amount));
    }

    //motivation : https://www.youtube.com/watch?v=jgiZlGzXMBw
    private static int recurse( int[] arr, int money, Map<Integer, Integer> dp ) {

        if (money == 0)
            return 0; //if no money left then don't include the last coin

        if (dp.containsKey(money)) //why map : bcz we recurse on money; each money should form unique number of times.
            return dp.get(money);

        int min = Integer.MAX_VALUE;

        //this recursion pattern is similar to RodCuttingMaxProfit
        for (int j = 0; j < arr.length; j++) {

            if (arr[j] > money)
                continue;

            //int ways = 1 + recurse(arr, money - arr[j], dp); //doing +1 here failing some test cases
            int ways = recurse(arr, money - arr[j], dp);

            min = Math.min(ways, min);
        }

        //if min doesn't change above so updating Min+1 for finding next min. number of coins..
        min = (min == Integer.MAX_VALUE ? min : min + 1);

        dp.put(money, min);
        return min;
    }

    //video: https://www.youtube.com/watch?v=jgiZlGzXMBw
    //https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/ChangeMakingProblem/ChangeMakingProblem.java
    private static int coinChangeBottonUp( int[] coins, int amount ) {

        int[] dp = new int[amount + 1]; //+1 bcz we need to find answer for amount only

        Arrays.fill(dp, Integer.MAX_VALUE);

        //to make zero-th amount -> 0 value coin is used
        dp[0] = 0;

        //eg:{1,2,3} amount = 11

        //TO make one amount -> {1} 1 coin is used
        //dp[1] = 1

        //To make two amount -> {1 ,2} -> 1 coin of denomination 2 is used
        //dp[2] = 1

        //To make amount of 3 we can do following: {1,2,5}
        //1. If we choose coin -> 1 : dp[3 - 1] => dp[2] => 1 + 1(bcz we choose 1 coin) => 2 {eg. by choosing 1 denomination of 1 and 1 denomination of 2}
        //dp[3] = 2
        //2. If we choose coin -> 2 : dp[3 - 2] => dp[1] => 1 + 1(bcz we choose 1 coin of 2) => 2 {eg. by choosing 1 denomination of 2 and 1 denomination of 1}
        //dp[3] = 2
        //3. We cant choose coin -> 5 : bcz it is greater than amount = 3

        for (int i = 1; i <= amount; i++) {

            // For each coin we are given
            for (int j = 0; j < coins.length; j++) {
                // If it is less than or equal to the sub problem amount
                if (coins[j] <= i) {
                    // Try it. See if it gives us a more optimal solution
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1); //+1 for choosing that coin[j]
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
