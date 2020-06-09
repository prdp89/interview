package com.interview.leetcode.dp.grokkingdp.boundedknapsacktype;

public class MinSubsetSumDiff {

    public static void main( String[] args ) {
        MinSubsetSumDiff ps = new MinSubsetSumDiff();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canPartition(num));

        System.out.println(ps.canPartition_2D_DP(num));

        System.out.println(ps.canPartition_1D_DP(num));
    }

    public int canPartition( int[] num ) {
        int sum = 0;
        for (int i = 0; i < num.length; i++)
            sum += num[i];

        Integer[][] dp = new Integer[num.length][sum + 1];
        return this.canPartitionRecursive(dp, num, 0, 0, 0);
    }

    private int canPartitionRecursive( Integer[][] dp, int[] num, int currentIndex, int sum1, int sum2 ) {
        // base check
        if (currentIndex == num.length)
            return Math.abs(sum1 - sum2);

        // check if we have not already processed similar problem
        if (dp[currentIndex][sum1] == null) {
            // recursive call after including the number at the currentIndex in the first set
            int diff1 = canPartitionRecursive(dp, num, currentIndex + 1, sum1 + num[currentIndex], sum2);

            // recursive call after including the number at the currentIndex in the second set
            int diff2 = canPartitionRecursive(dp, num, currentIndex + 1, sum1, sum2 + num[currentIndex]);

            dp[currentIndex][sum1] = Math.min(diff1, diff2);
        }

        return dp[currentIndex][sum1];
    }

    //same as com.interview.leetcode.dp.grokkingdp.boundedknapsacktype.PartitonEqualSubsetSum
    public int canPartition_2D_DP( int[] num ) {
        int n = num.length;
        // find the total sum

        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += num[i];

        int total = sum;

        // we are trying to find a subset of given numbers that has a total sum of ‘sum/2’.
        sum /= 2;

        boolean[][] dp = new boolean[n][sum + 1];

        // populate the sum=0 column, as we can always have '0' sum without including any element
        for (int i = 0; i < n; i++)
            dp[i][0] = true;

        // with only one number, we can form a subset only when the required sum is equal to its value
        for (int s = 1; s <= sum; s++) {
            dp[0][s] = (num[0] == s ? true : false);
        }

        // process all subsets for all sums
        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= sum; s++) {
                // if we can get the sum 's' without the number at index 'i'
                if (dp[i - 1][s]) {
                    dp[i][s] = dp[i - 1][s];
                } else if (s >= num[i]) { // else if we can find a subset to get the remaining sum
                    dp[i][s] = dp[i - 1][s - num[i]];
                }
            }
        }

        int sum1 = 0;
        // Find the largest index in the last row which is true
        for (int i = sum; i >= 0; i--) {
            if (dp[n - 1][i] == true) {
                sum1 = i;
                break;
            }
        }

        int sum2 = total - sum1;

        return Math.abs(sum2 - sum1);
    }

    //this is not working as PartitionEqualSubsetSum
    private int canPartition_1D_DP( int[] num ) {
        int n = num.length;
        // find the total sum

        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += num[i];

        int total = sum;

        // we are trying to find a subset of given numbers that has a total sum of ‘sum/2’.
        sum /= 2;

        boolean[] dp = new boolean[sum + 1];

        //populate the sum=0 column, as we can always have '0' sum without including any element
        dp[0] = true;

        for (int i = 1; i < n; i++) {

            for (int c = sum; c >= 0; c--) {
                boolean include = dp[c];

                boolean exclude = false;

                if (num[i] <= c) { //include the element state
                    exclude = dp[c - num[i]];
                }

                dp[c] = include || exclude;


               /* if (!dp[c] && c >= num[i]) {
                    dp[c] = dp[c - num[i]];
                }*/
            }
        }

        int sum1 = 0;

        // Find the largest index in the last row which is true
        for (int i = sum; i >= 0; i--) {
            if (dp[i]) {
                sum1 = i;
                break;
            }
        }

        int sum2 = total - sum1;

        return Math.abs(sum2 - sum1);
    }
}
