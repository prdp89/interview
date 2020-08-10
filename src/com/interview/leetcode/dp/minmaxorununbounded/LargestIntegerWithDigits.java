package com.interview.leetcode.dp.minmaxorununbounded;

public class LargestIntegerWithDigits {

    //https://leetcode.com/problems/form-largest-integer-with-digits-that-add-up-to-target/
    public static void main( String[] args ) {
        int[] cost = {4, 3, 2, 5, 6, 7, 2, 5, 5};
        int target = 9;

        System.out.println(largestNumber(cost, target));
    }

    //This pattern is same as CoinChangeMinCoins
    private static String largestNumber( int[] cost, int target ) {
        int[] dp = new int[target + 1];

        //We get Max number of digits to reach the target at: dp[target]
        for (int t = 1; t <= target; ++t) {

            dp[t] = -10000;

            for (int i = 0; i < 9; ++i) {
                if (t >= cost[i])
                    dp[t] = Math.max(dp[t], 1 + dp[t - cost[i]]);
            }
        }

        if (dp[target] < 0)
            return "0"; // not possible to reach target

        StringBuilder sb = new StringBuilder();

        for (int n = 8; n >= 0; n--) { // now that we know the max digits, we add possible numbers from large to small to get largest combination

            // verify that we can indeed use this relatively large digit, as many times as possible
            //cost = [4,3,2,5,6,7,2,5,5]
            //if Target = 9, then dp[9] = 4 [4 digits req. to form target  = 9]

            //9 > 2 :cost[6] && 9 == dp[9 - 2]  + 1 { dp[7] + 1 => 3 + 1 => 4}
            //sb.append => 6 + 1 => 7
            //target = 9 - 2 = 7
            while (target >= cost[n] && dp[target] == dp[target - cost[n]] + 1) {
                sb.append(n + 1);
                target -= cost[n];
            }
        }

        return sb.toString();
    }
}
