package com.interview.leetcode.dp.grokkingdp.distinctortotalwaystype;

public class HouseThief {

    /*
    Problem Statement #
    Given a number array representing the wealth of ‘n’ houses, determine the maximum amount of money the thief can steal without alerting the security system.

    Example 1:

    Input: {2, 5, 1, 3, 6, 2, 4}
    Output: 15
    Explanation: The thief should steal from houses 5 + 6 + 4
    Example 2:

    Input: {2, 10, 14, 8, 1}
    Output: 18
    Explanation: The thief should steal from houses 10 + 8

    The only restriction the thief has is that he can’t steal from two consecutive houses,
    as that would alert the security system. How should the thief maximize his stealing?
     */
    public static void main( String[] args ) {
        HouseThief ht = new HouseThief();
        int[] wealth = {2, 5, 1, 3, 6, 2, 4};
        System.out.println(ht.findMaxSteal(wealth));

        System.out.println(ht.findMaxSteal_1D_DP(wealth));
    }

    public int findMaxSteal( int[] wealth ) {
        int dp[] = new int[wealth.length];
        return findMaxStealRecursive(dp, wealth, 0);
    }

    private int findMaxStealRecursive( int[] dp, int[] wealth, int currentIndex ) {
        if (currentIndex >= wealth.length)
            return 0;

        if (dp[currentIndex] == 0) {
            // steal from current house and skip one to steal next
            int stealCurrent = wealth[currentIndex] + findMaxStealRecursive(dp, wealth, currentIndex + 2);
            // skip current house to steel from the adjacent house
            int skipCurrent = findMaxStealRecursive(dp, wealth, currentIndex + 1);

            dp[currentIndex] = Math.max(stealCurrent, skipCurrent);
        }
        return dp[currentIndex];
    }

    public int findMaxSteal_1D_DP( int[] wealth ) {
        if (wealth.length == 0) return 0;
        int dp[] = new int[wealth.length + 1]; // '+1' to handle the zero house

        dp[0] = 0; // if there are no houses, the thief can't steal anything
        dp[1] = wealth[0]; // only one house, so the thief have to steal from it

        // please note that dp[] has one extra element to handle zero house
        for (int i = 1; i < wealth.length; i++)
            dp[i + 1] = Math.max(wealth[i] + dp[i - 1], // steal from current house {wealth[i]} and skip one to steal next dp[i-1]

                    dp[i]); // skip current house to steel from the adjacent house; prev house

        return dp[wealth.length];
    }
}
