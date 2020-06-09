package com.interview.leetcode.dp.grokkingdp.boundedknapsacktype;

public class TargetSum {

    //https://leetcode.com/problems/target-sum/

    /*
    Now, let’s say ‘Sum(s1)’ denotes the total sum of set ‘s1’, and ‘Sum(s2)’ denotes the total sum of set ‘s2’. So the required equation is:

    Sum(s1) - Sum(s2) = S
    This equation can be reduced to the subset sum problem. Let’s assume that ‘Sum(num)’ denotes the total sum of all the numbers, therefore:

    Sum(s1) + Sum(s2) = Sum(num)
    Let’s add the above two equations:

    => Sum(s1) - Sum(s2) + Sum(s1) + Sum(s2) = S + Sum(num)
    => 2 * Sum(s1) =  S + Sum(num)
    => Sum(s1) = (S + Sum(num)) / 2
    This essentially converts our problem to: “Find count of subsets of the given numbers whose sum is equal to”,

    => (S + Sum(num)) / 2
     */
    public static void main( String[] args ) {
        TargetSum ts = new TargetSum();
        int[] num = {1, 1, 2, 3};
        System.out.println(ts.findTargetSubsets_1D_DP(num, 1));

        System.out.println(ts.countSubsets_2D_DP(num, 1));
    }

    //Runtime: 2 ms, faster than 94.82% of Java online
    public int findTargetSubsets_1D_DP( int[] num, int s ) {
        int totalSum = 0;
        for (int n : num)
            totalSum += n;

        // if 's + totalSum' is odd, we can't find a subset with sum equal to '(s + totalSum) / 2'
        if (totalSum < s || (s + totalSum) % 2 == 1)
            return 0;

        return countSubsets(num, (s + totalSum) / 2);
    }

    // this function is exactly similar to what we have in 'Count of Subset Sum' problem.
    private int countSubsets( int[] num, int sum ) {
        int n = num.length;
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        //doesn't need this code for Leetcode
        // with only one number, we can form a subset only when the required sum is equal to the number
       /* for (int s = 1; s <= sum; s++) {
            dp[s] = (num[0] == s ? 1 : 0);
        }*/

        // process all subsets for all sums
        for (int i = 1; i < num.length; i++) { //for leetcode index should start with 1
            for (int s = sum; s >= 0; s--) {
                if (s >= num[i])
                    dp[s] += dp[s - num[i]];
            }
        }

        return dp[sum];
    }

    // this function is exactly similar to what we have in 'Count of Subset Sum' problem.
    //122 / 139 test cases passed.
    public int countSubsets_2D_DP( int[] num, int sum ) {
        int n = num.length;
        int[][] dp = new int[n][sum + 1];

        // populate the sum=0 columns, as we will always have an empty set for zero sum
        for (int i = 0; i < n; i++)
            dp[i][0] = 1;

        // with only one number, we can form a subset only when the required sum is equal to the number
        for (int s = 1; s <= sum; s++) {
            dp[0][s] = (num[0] == s ? 1 : 0);
        }

        // process all subsets for all sums
        for (int i = 1; i < num.length; i++) {
            for (int s = 1; s <= sum; s++) {
                //if (i > 0)
                {
                    dp[i][s] = dp[i - 1][s];

                    if (s >= num[i])
                        dp[i][s] += dp[i - 1][s - num[i]];
                }
            }
        }

        // the bottom-right corner will have our answer.
        return dp[num.length - 1][sum];
    }
}
