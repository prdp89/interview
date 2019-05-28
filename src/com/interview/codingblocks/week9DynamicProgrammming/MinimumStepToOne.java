package com.interview.codingblocks.week9DynamicProgrammming;

import java.util.Arrays;

public class MinimumStepToOne {

    private static int[] memo = new int[10000];

    // 21 : 21-------> 7-------->6------->2------->1  == 4 steps total
    //         /3           -1      /3       -1
    //THis is we have tried greedy by dividing with greatest number and go on..

    //But this greedy fails here:
    // 10 : 10-------> 5---------->4-------->2--------->1 == 4 steps
    //          /2          -1          /2       /2
    //But it can solved in 3 steps:
    // 10 : 10--------> 9----------->3---------->1 == 3 steps
    //          /-1      /3          /3
    //This means we have to try all the possible combinations....

    //https://www.youtube.com/watch?v=AjR5QBk5Si4
    public static void main( String[] args ) {
        Arrays.fill(memo, -1);

        //System.out.println(solveInMinimumSteps(6, 0));

        long startTime = System.nanoTime();

        System.out.println("Answer of all combination: " + solveMinimumStepsAllCombinations(500));

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Time: " + totalTime);

        long startTimeMemoization = System.nanoTime();

        System.out.println("Answer of Memoization DP: " + solveMinimumStepsAllCombinationsMemoization(500));

        long endTimeMemoization = System.nanoTime();
        long totalTimeMemoization = endTimeMemoization - startTimeMemoization;
        System.out.println("Time : " + totalTimeMemoization);

        long startBottomupDP = System.nanoTime();

        System.out.println("Answer of Bottom Up DP : " + solveMinimumStepsAllCombinationsBottomUpDP(500));

        long endTimeBottomUP = System.nanoTime();
        long totalTimeBottomUp = endTimeBottomUP - startBottomupDP;
        System.out.println("Time : " + totalTimeBottomUp);
    }

    //In this Approach: We are figuring different combinations to reach to 1 in minimum steps.
    //let n = 21 :
    // step 1 : if(n % 3 == 0) 1 + rec(n / 3)
    // step 2 : if(n % 2 == 0) 1 + rec(n / 2)
    // step 3 : 1 + rec(n - 1)
    // Then find :  Min(Step 1, step 2, step 3)

    private static int solveInMinimumSteps( int num, int steps ) {
        if (num == 1)
            return steps;

        if (num % 3 == 0) {
            return solveInMinimumSteps(num / 3, steps + 1);
        } else if (num % 2 == 0) {
            return solveInMinimumSteps(num / 2, steps + 1);
        } else {
            return solveInMinimumSteps(num - 1, steps + 1);
        }
    }

    //For 21 : min steps : 4
    //For 10 : min steps : 3
    //Time complexity : O ( 3 ^ N ) : 3 branch or option at each level
    private static int solveMinimumStepsAllCombinations( int num ) {

        //This must be local, if declare global answer will be wrong
        int q1 = Integer.MAX_VALUE, q2 = Integer.MAX_VALUE, q3;

        if (num == 1)
            return 0;

        if (num % 3 == 0)
            q1 = 1 + solveMinimumStepsAllCombinations(num / 3);

        if (num % 2 == 0)
            q2 = 1 + solveMinimumStepsAllCombinations(num / 2);

        q3 = 1 + solveMinimumStepsAllCombinations(num - 1);

        return Math.min(q1, Math.min(q2, q3));
    }

    //Eg. If we are finding Min steps for: 21
    //With this approach we Memoize the number of steps taken at each number 1...2..3...21
    //So we don't need to compute steps again.
    //Time complexity : O ( N ) due to memoization.
    private static int solveMinimumStepsAllCombinationsMemoization( int num ) {

        //This must be local, if declare global answer will be wrong
        int q1 = Integer.MAX_VALUE, q2 = Integer.MAX_VALUE, q3;

        if (num == 1)
            return 0;

        if (memo[num] != -1) //if min steps are already computed for a number, return from Memo array
            return memo[num];

        if (num % 3 == 0)
            q1 = 1 + solveMinimumStepsAllCombinationsMemoization(num / 3);

        if (num % 2 == 0)
            q2 = 1 + solveMinimumStepsAllCombinationsMemoization(num / 2);

        q3 = 1 + solveMinimumStepsAllCombinationsMemoization(num - 1);

        memo[num] = Math.min(q1, Math.min(q2, q3)); //memoize have to be done!!
        return memo[num];
    }

    //Time Complexity : O ( N )
    //Better than Memoization- Top down dp : Bcz we are not maintaining function stack.
    private static int solveMinimumStepsAllCombinationsBottomUpDP( int num ) {

        int dp[] = new int[10000];

        //Setting base Minimum value to Reach ith index after : i/3 or i/2 or i - 1
        dp[0] = 0; //min. steps to reach 0th index is 0
        dp[2] = 1; //min. steps to reach i = 2(index) is : {by dividing it 2 : 2/2 = 1 min. steps}
        dp[1] = 0;
        dp[3] = 1; //min. steps to reach i = 3(index) is : {by dividing it 3 : 3/3 = 1 min. steps}

        //now compute the answer for N or num
        for (int curNum = 4; curNum <= num; curNum++) {

            int q1 = Integer.MAX_VALUE;
            int q2 = Integer.MAX_VALUE;
            int q3;

            //if number divides by 3 : pick minimum steps from dp[ curNum / 3]
            if (curNum % 3 == 0) {
                q1 = 1 + dp[curNum / 3];
            }

            if (curNum % 2 == 0) {
                q2 = 1 + dp[curNum / 2];
            }

            q3 = 1 + dp[curNum - 1];

            dp[curNum] = Math.min(q1, Math.min(q2, q3));
        }

        return dp[num];
    }
}