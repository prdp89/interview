package com.interview.codingblocks.week9DynamicProgrammming;

import java.util.Arrays;

public class OptimalGameStrategy {

    private static int[][] memo = new int[100][100];

    //https://online.codingblocks.com/player/3880/content/161?s=687
    //Stackover : https://stackoverflow.com/questions/22195300/understanding-solution-to-finding-optimal-strategy-for-game-involving-picking-po
    public static void main( String[] args ) {

        int a[] = {3, 9, 1, 2};
        /*
        Suppose players are: Bill and Trump, Bill has to win by Max. profit. Bill always plays first

        Step 1 : {3, 9, 1, 2}
        Bill choose : 2
        Trump choose : 3  : {3, 9, 1}

        Step 2 : {9, 1}
        Bill choose : 9
        Trump choose : 1 {3, 2, 5}

        Bill total : 9 + 2 = 11
        Trump total : 3 + 2 = 5

        output : 11

         */

        long startTime = System.nanoTime();

        System.out.println(solveRecursive(a, 0, a.length - 1));

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Time Recursive: " + totalTime);

        //---------------------------------------------------------------------------

        long startTimeMemoization = System.nanoTime();

        // Fill each row with -1
        for (int[] row : memo)
            Arrays.fill(row, -1);

        System.out.println(solveTopDownMemo(a, 0, a.length - 1));

        long endTimeMemoization = System.nanoTime();
        long totalTimeMemoization = endTimeMemoization - startTimeMemoization;
        System.out.println("Time Top Down DP : " + totalTimeMemoization);


        //------------------------------------------------------------------------------


    }

    private static int solveRecursive( int[] coin, int start, int end ) {

        if (start > end)
            return 0;

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

        int a = coin[start] +
                Math.min(solveRecursive(coin, start + 2, end),
                        solveRecursive(coin, start + 1, end - 1));

        int b = coin[end] +
                Math.min(solveRecursive(coin, start + 1, end - 1),
                        solveRecursive(coin, start, end - 2));

        return Math.max(a, b);
    }

    private static int solveTopDownMemo( int[] coin, int start, int end ) {

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

        int a = coin[start] +
                Math.min(solveTopDownMemo(coin, start + 2, end),
                        solveTopDownMemo(coin, start + 1, end - 1));

        int b = coin[end] +
                Math.min(solveTopDownMemo(coin, start + 1, end - 1),
                        solveTopDownMemo(coin, start, end - 2));

        int max = Math.max(a, b);
        memo[start][end] = max;

        return max;
    }



    /*

    //for Bottom Up DP : https://www.youtube.com/watch?v=WxpIHvsu1RI
    //The matrix need to be fill in diagonal form. Watch the awesome video.

     */

}
