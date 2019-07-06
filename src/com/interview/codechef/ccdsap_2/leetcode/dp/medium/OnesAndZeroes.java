package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

public class OnesAndZeroes {

    //https://leetcode.com/problems/ones-and-zeroes/

    //very easy problem
    public static void main( String[] args ) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;

        System.out.println(findMaxForm(strs, m, n));
    }

    private static int findMaxForm( String[] strs, int m, int n ) {
        int[][][] dp = new int[m+1][n + 1][strs.length];

        return findMaxFormStartingWith(strs, m, n, 0, dp );
    }

    //it use include-exclude principle
    //This problem is similar tp PartitionEqualSubsetSum
    private static int findMaxFormStartingWith( String[] strs, int m, int n, int begin, int[][][] dp ) {
        if ((begin == strs.length) || (m + n == 0)) { //if we have no zero/one left
            return 0;
        }

        if(dp[m][n][begin] > 0)
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
}
