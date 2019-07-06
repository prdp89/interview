package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.HashMap;
import java.util.Map;

public class CoinChangeMinCoins {

    //https://leetcode.com/problems/coin-change/
    public static void main( String[] args ) {
/*
        int[] coins = {1, 2, 5};
        int amount = 11; //op : 3 {5, 5, 1}
*/

        int amount = 285;
        int coins[] = {384, 324, 196, 481};

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
    }

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
}
