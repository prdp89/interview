package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.HashMap;
import java.util.Map;

public class DiceRollWithTargetSum {

    private static Map<String, Integer> memo = new HashMap<>();

    //https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
    public static void main( String[] args ) {

        int d = 2, f = 6, T = 7;

        System.out.println(recursive(d, f, T));

        System.out.println("bottomUp : " + bottomUp(d, f, T));

        System.out.println("trying : " + dice_try_1D_DP(d, f, T));
    }

    //Runtime: 18 ms, faster than 48.52% of Java
    private static int bottomUp( int dices, int f, int target ) {

        int[] dp = new int[target + 1];

        dp[0] = 1;

        for (int i = 1; i <= dices; i++) {

            int[] temp = new int[target + 1];

            //this loop is same as loop of CoinChangeMinCoins
            for (int j = 0; j <= target; j++) {

                for (int faces = 1; faces <= f; faces++) {

                    //bcz doing this will change the original array
                    /*if (j >= faces)
                        dp[j] = dp[j] + dp[j - f];*/

                    //now compare this line with : if (coins[j] <= i) {}
                    if (faces <= j)
                        temp[j] = (temp[j] + dp[j - faces]) % 1000000007;
                }
            }

            //in-case of multiple states we keep temp array as : TargetSum
            dp = temp;
        }

        return dp[target];
    }

    //similar to CoinChangeTotalWays
    //only diff. is in place is coin[] array we have dices and,
    //one extra param : f faces to loop through to generate target sum.

    //this backtrack is same as : CombinationSum --> method-2
    //We have 2 states here : 1. number of dice we roll 2. Target we want to achieve
    //Runtime: 318 ms, faster than 5.01% of Java online submissions
    //Runtime: O(d * f * target).
    //Memory: O(d * target) for the memoization.
    private static int recursive( int dice, int face, int target ) {

        if (dice == 0 && target == 0) {
            return 1;
        }

        if (dice == 0 || target == 0) {
            return 0;
        }

        String str = dice + " " + target;
        if (memo.containsKey(str)) {
            return memo.get(str);
        }

        int res = 0;
        for (int i = 1; i <= face; i++) {
            //see here: only one recursive call, no include-exclude principle
            res = (res + recursive(dice - 1, face, target - i)) % 1000000007;
        }

        memo.put(str, res);

        return res;
    }

    //Runtime: 29 ms, faster than 52.29% of Java
    //using combination ways of : countChange_1D_DP CoinChangeMin --> com.interview.leetcode.dp.grokkingdp.unboundedknapscaktype
    private static int dice_try_1D_DP( int dice, int face, int target ) {
        int[] dp = new int[target + 1];

        dp[0] = 1;

        for (int d = 1; d <= dice; d++) {

            int[] dp1 = new int[target + 1];

            for (int i = 1; i <= face; i++) {

                for (int t = i; t <= target; t++) {
                    int include = 0, exclude = 0;

                    if (i > 0)
                        exclude = dp1[t]; //exclude the coin

                    if (t >= i) {
                        dp1[t] = dp[t - i] + exclude; //using dp picking prev dice state
                    }
                }
            }

            dp = dp1;
        }

        return dp[target];
    }
}