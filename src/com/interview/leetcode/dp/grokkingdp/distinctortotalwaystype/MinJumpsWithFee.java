package com.interview.leetcode.dp.grokkingdp.distinctortotalwaystype;

public class MinJumpsWithFee {

    /*
    At every step, you have an option to take either 1 step, 2 steps, or 3 steps.
    You should assume that you are standing at the first step.

    Number of stairs (n) : 6
    Fee: {1,2,5,2,1,2}
    Output: 3
    Explanation: Starting from index '0', we can reach the top through: 0->3->top
    The total fee we have to pay will be (1+2).
     */

    //REaD: MinStepToReach1
    public static void main( String[] args ) {
        MinJumpsWithFee sc = new MinJumpsWithFee();
        int[] fee = {1, 2, 5, 2, 1, 2};

        System.out.println(sc.findMinFee(fee));

        System.out.println(sc.findMinFee_1D_DP(fee));
    }

    public int findMinFee( int[] fee ) {
        int dp[] = new int[fee.length];
        return findMinFeeRecursive(dp, fee, 0);
    }

    private int findMinFeeRecursive( int[] dp, int[] fee, int currentIndex ) {
        if (currentIndex > fee.length - 1)
            return 0;

        if (dp[currentIndex] == 0) {
            // if we take 1 step, we are left with 'n-1' steps;
            int take1Step = findMinFeeRecursive(dp, fee, currentIndex + 1);
            // similarly, if we took 2 steps, we are left with 'n-2' steps;
            int take2Step = findMinFeeRecursive(dp, fee, currentIndex + 2);
            // if we took 3 steps, we are left with 'n-3' steps;
            int take3Step = findMinFeeRecursive(dp, fee, currentIndex + 3);

            dp[currentIndex] = fee[currentIndex] + Math.min(Math.min(take1Step, take2Step), take3Step);
        }

        return dp[currentIndex];
    }

    public int findMinFee_1D_DP( int[] fee ) {
        int dp[] = new int[fee.length + 1]; // +1 to handle the 0th step
        dp[0] = 0; // if there are no steps, we don't have to pay any fee

        dp[1] = fee[0]; // only one step, so we have to pay its fee

        // for 2 or 3 steps staircase, since we start from the first step so we have to pay its fee
        // and from the first step we can reach the top by taking two or three steps, so we don't
        // have to pay any other fee.
        dp[2] = fee[0]; //Math.min(0, dp[i-1])

        dp[3] = fee[0];

        for (int i = 3; i < fee.length; i++)
            dp[i + 1] = Math.min(fee[i] + dp[i] //if coming from prev step, bring its fees too
                    , Math.min(fee[i - 1] + dp[i - 1]
                            , fee[i - 2] + dp[i - 2]));

        return dp[fee.length];
    }
}
