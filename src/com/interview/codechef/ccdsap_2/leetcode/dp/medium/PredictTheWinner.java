package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.Arrays;

//https://leetcode.com/problems/predict-the-winner/
public class PredictTheWinner {

    public static void main( String[] args ) {
        int[] arr = {1, 5, 233, 7};

        int[][] dp = new int[arr.length + 1][arr.length + 1];

        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        int firstPlayerBest = solveTopDownMemo(arr, 0, arr.length - 1, dp);

        System.out.println(2 * firstPlayerBest >= sum);
    }

    //https://stackoverflow.com/questions/22195300/understanding-solution-to-finding-optimal-strategy-for-game-involving-picking-po
    private static int solveTopDownMemo( int[] arr, int start, int end, int[][] memo ) {

        if (start > end)
            return 0;

        if (memo[start][end] != -1)
            return memo[start][end];

        /*
        First of all a and b represent respectively the maximum gain if start (respectively end)
        is played
         */

         /*
        If I play start, I will immediately gain(pick) from coin[start].
        The other player now has to play between start+1 and end. He plays to maximize his gain.
        However since the number of coin is fixed, this amounts to minimize mine. Note that:

        - if he plays start+1 I'll gain max_coin(coin, start+2, end)
        - if he plays end Ill gain max_coin(coin, start+1, end-1)

        Since he tries to minimize my gain, I'll gain the minimum of those two.
         */

        int a = arr[start] +
                Math.min(solveTopDownMemo(arr, start + 2, end, memo),
                        solveTopDownMemo(arr, start + 1, end - 1, memo));

        int b = arr[end] +
                Math.min(solveTopDownMemo(arr, start + 1, end - 1, memo),
                        solveTopDownMemo(arr, start, end - 2, memo));

        int max = Math.max(a, b);
        memo[start][end] = max;

        return max;
    }
}
