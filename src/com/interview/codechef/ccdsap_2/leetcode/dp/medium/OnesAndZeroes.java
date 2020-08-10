package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

public class OnesAndZeroes {

    //https://leetcode.com/problems/ones-and-zeroes/

    //very easy problem
    public static void main( String[] args ) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;

        System.out.println(findMaxForm(strs, m, n));

        System.out.println(findMaxForm_BottomUpDP(strs, m, n));

        System.out.println(findMaxForm_BottomUpDP_BasedOnRecursion(strs, m, n));
    }

    private static int findMaxForm( String[] strs, int m, int n ) {
        int[][][] dp = new int[m + 1][n + 1][strs.length];

        return findMaxFormStartingWith(strs, m, n, 0, dp);
    }

    //it use include-exclude principle
    //This problem is similar tp PartitionEqualSubsetSum
    private static int findMaxFormStartingWith( String[] strs, int m, int n, int begin, int[][][] dp ) {
        if ((begin == strs.length) || (m + n == 0)) { //if we have no zero/one left
            return 0;
        }

        if (dp[m][n][begin] > 0)
            return dp[m][n][begin];

        int countByAddingString = 0;

        String current = strs[begin];

        int zeroes = countZeroesIn(current);

        int ones = current.length() - zeroes;

        //including by subtracting zero's and One's from total M , N
        if (m >= zeroes && n >= ones) {
            countByAddingString = 1 + findMaxFormStartingWith(strs, m - zeroes, n - ones, begin + 1, dp);
        }

        //excluding by switching to next array element
        int countBySkippingString = findMaxFormStartingWith(strs, m, n, begin + 1, dp);

        return dp[m][n][begin] = Math.max(countByAddingString, countBySkippingString);
    }

    private static int countZeroesIn( String str ) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                count++;
            }
        }
        return count;
    }

    //This solution is similar to Recursive pattern and easy to understand..
    private static int findMaxForm_BottomUpDP_BasedOnRecursion( String[] strs, int m, int n ) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

        for (int i = 1; i <= strs.length; i++) {

            for (int j = 0; j <= m; j++) {

                for (int k = 0; k <= n; k++) {

                    int zeros = countZeroesIn(strs[i - 1]);

                    int ones = strs[i - 1].length() - zeros;
                    int res = dp[i - 1][j][k];

                    //similar to ZeroOneKnapsack
                    if (zeros <= j && ones <= k)
                        res = Math.max(res, dp[i - 1][j - zeros][k - ones] + 1);

                    dp[i][j][k] = res;
                }
            }
        }

        return dp[strs.length][m][n];
    }

    //After using this approach, the above 3D dp has been reduce to 2D DP.
    private static int findMaxForm_BottomUpDP( String[] strs, int m, int n ) {
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int one = 0;
            int zero = 0;

            for (char c : str.toCharArray()) {
                if (c == '1')
                    one++;
                else
                    zero++;
            }

            //similar to bottom up dp knapsack; using inclusive-exclusive principle

            // dp[i][j] = the max number of strings that can be formed with i 0's and j 1's
            // from the first few strings up to the current string s
            // Catch: have to go from bottom right to top left
            for (int i = m; i >= zero; i--)
                for (int j = n; j >= one; j--)
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
        }

        return dp[m][n];
    }
}
