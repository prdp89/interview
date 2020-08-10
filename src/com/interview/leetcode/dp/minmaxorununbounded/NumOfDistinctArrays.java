package com.interview.leetcode.dp.minmaxorununbounded;

public class NumOfDistinctArrays {

    /*
    Given a sum of elements (n) and a number of elements (k), find the number of distinct arrays under these conditions:

    In each array, the there are k elements whose sum is equal to n.

    In each array, each element should be greater than or equal to the element on its left.

    The elements formed in each array are distinct

    Edit: elements have to be positive integers
     */

    /*
    n = 8 k = 4

    Answer: 5

    Explanation: [1,1,1,5], [1,1,2,4], [1,1,3,3], [1,2,2,3], [2,2,2,2]

    Each array has 4 (k) elements a sum of 8 (n) with each element on the left <= element on the right. There are 5 possible distinct options.
    */

    //https://leetcode.com/discuss/interview-question/775392/got-this-in-an-interview-how-to-solve
    public static void main( String[] args ) {
        int n = 8, k = 4;

        System.out.println(calculateTotal(8, 4));
    }

    private static int calculateTotal( int sum, int numOfElements ) {
        if (numOfElements == 0) {
            if (sum == 0)
                return 1;
            return 0;
        }

        if (numOfElements > sum)
            return 0;

        int[][] dp = new int[sum + 1][numOfElements + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= sum; i++) {

            for (int j = 1; j <= numOfElements; j++) {

               /* if (j > i)
                    break;*/

                //similar to CoinChangeMinCoins : only diff. is we need to find total number of ways.
                if (j <= i)
                    dp[i][j] = dp[i - j][j] + dp[i - 1][j - 1]; // Because one element can appear more than once in an answer
            }
        }

        return dp[sum][numOfElements];
    }

    /*int calculateTotal( int sum, int numOfElements ) {
        if (numOfElements == 0) {
            if (sum == 0)
                return 1;
            return 0;
        }
        if (numOfElements > sum)
            return 0;
        vector<vector<int>> DP (sum + 1, vector <int>(numOfElements + 1, 0));
        DP[0][0] = 1;
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= numOfElements; j++) {
                if (j > i)
                    break;
                DP[i][j] = DP[i - j][j] + DP[i - 1][j - 1]; // Because one element can appear more than once in an answer
            }
        }
        return DP[sum][numOfElements];
    }*/
}
