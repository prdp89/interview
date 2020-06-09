package com.interview.leetcode.dp.grokkingdp.boundedknapsacktype;

public class SubsetSumCount {

    public static void main( String[] args ) {
        SubsetSumCount ss = new SubsetSumCount();
        int[] num = {1, 1, 2, 3};
        System.out.println(ss.countSubsets(num, 4));

        System.out.println(ss.countSubsets_2d_DP(num, 4));

        System.out.println(ss.countSubsets_1D_DP(num, 4));
    }

    public int countSubsets( int[] num, int sum ) {
        Integer[][] dp = new Integer[num.length][sum + 1];
        return this.countSubsetsRecursive(dp, num, sum, 0);
    }

    private int countSubsetsRecursive( Integer[][] dp, int[] num, int sum, int currentIndex ) {
        // base checks
        if (sum == 0)
            return 1;

        if (num.length == 0 || currentIndex >= num.length)
            return 0;

        // check if we have not already processed a similar problem
        if (dp[currentIndex][sum] == null) {
            // recursive call after choosing the number at the currentIndex
            // if the number at currentIndex exceeds the sum, we shouldn't process this
            int sum1 = 0;
            if (num[currentIndex] <= sum)
                sum1 = countSubsetsRecursive(dp, num, sum - num[currentIndex], currentIndex + 1);

            // recursive call after excluding the number at the currentIndex
            int sum2 = countSubsetsRecursive(dp, num, sum, currentIndex + 1);

            dp[currentIndex][sum] = sum1 + sum2;
        }

        return dp[currentIndex][sum];
    }

    //same as PartitionEqualSubsetSum
    public int countSubsets_2d_DP( int[] num, int sum ) {
        int n = num.length;
        int[][] dp = new int[n][sum + 1];

        // populate the sum=0 columns, as we will always have an empty set for zero sum
        for (int i = 0; i < n; i++)
            dp[i][0] = 1;

        // with only one number, we can form a subset only when the required sum is equal to its value
        for (int s = 1; s <= sum; s++) {
            dp[0][s] = (num[0] == s ? 1 : 0);
        }

        // process all subsets for all sums
        for (int i = 1; i < num.length; i++) {
            for (int s = 1; s <= sum; s++) {
                // exclude the number
                dp[i][s] = dp[i - 1][s];
                // include the number, if it does not exceed the sum
                if (s >= num[i])
                    dp[i][s] += dp[i - 1][s - num[i]];
            }
        }

        // the bottom-right corner will have our answer.
        return dp[num.length - 1][sum];
    }

    private int countSubsets_1D_DP( int[] num, int sum ) {
        int n = num.length;
        int[] dp = new int[sum + 1];

        dp[0] = 1;

        // with only one number, we can form a subset only when the required sum is equal to its value
        //OR in Simple lang: Each number can form a subset of length = 1.
        for (int s = 1; s <= sum; s++) {
            dp[s] = (num[0] == s ? 1 : 0);
        }

        // process all subsets for all sums
        for (int i = 1; i < num.length; i++) {
            for (int s = sum; s >= 0; s--) {
                if (s >= num[i])
                    dp[s] += dp[s - num[i]];
            }
        }

        return dp[sum];
    }
}
