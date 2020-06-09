package com.interview.leetcode.dp.grokkingdp.distinctortotalwaystype;

public class MinJumpsToReachEnd {

    //https://leetcode.com/problems/jump-game-ii/
    public static void main( String[] args ) {
        MinJumpsToReachEnd aj = new MinJumpsToReachEnd();
        int[] jumps = {2, 1, 1, 1, 4};

        int[] dp = new int[jumps.length];
        System.out.println(aj.countMinJumpsRecursive(dp, jumps, 0));

        System.out.println(aj.jump_1d_dp(jumps));
    }

    //91 / 92 test cases passed. TLE
    private int countMinJumpsRecursive( int[] dp, int[] jumps, int currentIndex ) {
        // if we have reached the last index, we don't need any more jumps
        if (currentIndex == jumps.length - 1)
            return 0; //same as coinchangemincoins recurrence

        // If an element is 0, then we cannot move through that element
        if (jumps[currentIndex] == 0)
            return Integer.MAX_VALUE;

        // if we have already solved this problem, return the result
        if (dp[currentIndex] != 0)
            return dp[currentIndex];

        int totalJumps = Integer.MAX_VALUE;
        int start = currentIndex + 1;
        int end = currentIndex + jumps[currentIndex];

        while (start < jumps.length && start <= end) {
            // jump one step and recurse for the remaining array
            int minJumps = countMinJumpsRecursive(dp, jumps, start++); //only start++ works here

            if (minJumps != Integer.MAX_VALUE)
                totalJumps = Math.min(totalJumps, minJumps + 1);
        }
        dp[currentIndex] = totalJumps;
        return dp[currentIndex];
    }

    public int jump_1d_dp( int[] jumps ) {
        // int dp[] = new int[jumps.length];
        //return this.countMinJumpsRecursive(dp, jumps, 0);

        int[] dp = new int[jumps.length];

        //initialize with infinity, except the first index which should be zero as we start from there
        for (int i = 1; i < jumps.length; i++)
            dp[i] = Integer.MAX_VALUE;

        for (int start = 0; start < jumps.length - 1; start++) {

            for (int end = start + 1; end <= start + jumps[start] && end < jumps.length; end++)
                dp[end] = Math.min(dp[end], dp[start] + 1); //ALMOST same as CoinChangeMinCoins
        }

        return dp[jumps.length - 1];
    }

}
