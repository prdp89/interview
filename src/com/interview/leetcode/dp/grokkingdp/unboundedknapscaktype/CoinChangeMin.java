package com.interview.leetcode.dp.grokkingdp.unboundedknapscaktype;

public class CoinChangeMin {

    public static void main( String[] args ) {
        CoinChangeMin cc = new CoinChangeMin();
        int[] denominations = {1, 2, 3};
        System.out.println(cc.countChange(denominations, 5));

        System.out.println(cc.countChange_2D_DP(denominations, 5));

        System.out.println(cc.countChange_1D_DP(denominations, 5));
    }

    public int countChange( int[] denominations, int total ) {
        Integer[][] dp = new Integer[denominations.length][total + 1];
        int result = this.countChangeRecursive(dp, denominations, total, 0);
        return (result == Integer.MAX_VALUE ? -1 : result);
    }

    private int countChangeRecursive( Integer[][] dp, int[] denominations, int total, int currentIndex ) {
        // base check
        if (total == 0) //this base check is diff. from CoinChangeWays
            return 0;

        if (denominations.length == 0 || currentIndex >= denominations.length)
            return Integer.MAX_VALUE;

        // check if we have not already processed a similar sub-problem
        if (dp[currentIndex][total] == null) {
            // recursive call after selecting the coin at the currentIndex
            // if the coin at currentIndex exceeds the total, we shouldn't process this
            int count1 = Integer.MAX_VALUE;
            if (denominations[currentIndex] <= total) {
                int res = countChangeRecursive(dp, denominations, total - denominations[currentIndex], currentIndex);
                if (res != Integer.MAX_VALUE) {
                    count1 = res + 1;
                }
            }

            // recursive call after excluding the coin at the currentIndex
            int count2 = countChangeRecursive(dp, denominations, total, currentIndex + 1);
            dp[currentIndex][total] = Math.min(count1, count2);
        }

        return dp[currentIndex][total];
    }

    //Runtime: 37 ms, faster than 14.33% of Java online submissions for Coin Change.
    //https://leetcode.com/submissions/detail/349838181/
    public int countChange_2D_DP( int[] denominations, int total ) {
        int n = denominations.length;
        int[][] dp = new int[n][total + 1];

        for (int i = 0; i < n; i++)
            for (int j = 0; j <= total; j++)
                dp[i][j] = Integer.MAX_VALUE;

        // populate the total=0 columns, as we don't need any coin to make zero total
        for (int i = 0; i < n; i++)
            dp[i][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int t = 1; t <= total; t++) {
                if (i > 0)
                    dp[i][t] = dp[i - 1][t]; //exclude the coin

                if (t >= denominations[i]) {
                    if (dp[i][t - denominations[i]] != Integer.MAX_VALUE)
                        dp[i][t] = Math.min(dp[i][t], dp[i][t - denominations[i]] + 1); // include the coin
                }
            }
        }

        // total combinations will be at the bottom-right corner.
        return (dp[n - 1][total] == Integer.MAX_VALUE ? -1 : dp[n - 1][total]);
    }

    //Runtime: 15 ms, faster than 44.03% of Java
    //done by me :)
    public int countChange_1D_DP( int[] denominations, int total ) {
        int n = denominations.length;
        int[] dp = new int[total + 1];

        for (int j = 0; j <= total; j++)
            dp[j] = Integer.MAX_VALUE;

        dp[0] = 0;

        for (int i = 0; i < n; i++) {

            for (int t = denominations[i]; t <= total; t++) {
                int include = Integer.MAX_VALUE, exclude = Integer.MAX_VALUE;

                if (i > 0)
                    exclude = dp[t]; //exclude the coin

                if (t >= denominations[i]) {
                    if (dp[t - denominations[i]] != Integer.MAX_VALUE)
                        include = 1 + dp[t - denominations[i]]; // include the coin
                }

                dp[t] = Math.min(exclude, include);
            }
        }

        // total combinations will be at the bottom-right corner.
        return (dp[total] == Integer.MAX_VALUE ? -1 : dp[total]);
    }

    //One more way... :)
    //CoinChangeMinCoins : com.interview.codechef.ccdsap_2.leetcode.dp.medium
}
