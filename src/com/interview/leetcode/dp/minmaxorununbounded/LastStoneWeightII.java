package com.interview.leetcode.dp.minmaxorununbounded;

public class LastStoneWeightII {

    //https://leetcode.com/problems/last-stone-weight-ii/

    //This qurstion is same as MinSubsetSumDiff : com.interview.leetcode.dp.grokkingdp.boundedknapsacktype
    public static void main( String[] args ) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeightII(stones));
    }

    private static int lastStoneWeightII( int[] stones ) {

        int sum = 0;
        for (int stone : stones)
            sum += stone;

        //bcz we have to calulate for total weight of items
        int[] dp = new int[sum / 2 + 1];

        //Loop same as KnapSack1
        for (int i = 0; i < stones.length; i++) {

            for (int j = sum / 2; j >= stones[i]; j--) {

                //SubsetSumCount : Calculating Max Subset sum count..
                dp[j] = Math.max(dp[j]
                        , stones[i] + dp[j - stones[i]]);
            }
        }

        //i tried with dp[sum+1] and : return sum - dp[sum]; didn't worked..
        return sum - 2 * dp[sum / 2];
    }
}
