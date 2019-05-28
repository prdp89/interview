package com.interview.codingblocks.week9DynamicProgrammming;

import java.util.Scanner;

public class RodCuttingMaxProfit {

    private static int[] memo = new int[100];

    //If length = 0 then profit = 0
    //If length  = 4 then cut and lengths are:
    //  cut        length
    //  1           3            (Put cut at one and find length of 3 through recursion)
    //  2           2            (Put cut at two and find length of 2 through recursion)
    //  3           1            (Put cut at three and find length of 1 through recursion)
    //  4           0            (Put cut at four and find length of 0 through recursion)

    //https://www.youtube.com/watch?v=ItGgZ5oMBn0
    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);

        //int rodLength = 4;
        //int[] pieceProfit = {2, 3, 2, 5};

        int rodLength = scanner.nextInt();
        int[] pieceProfit = new int[100];


        for (int eachPiece = 1; eachPiece <= rodLength; eachPiece++) {
            pieceProfit[eachPiece] = scanner.nextInt();
        }

        //MAXPROFIT = by selling piece[0] four times.
        //System.out.println(solveRecursive(rodLength, pieceProfit));

        //Arrays.fill(memo, -1);
        //System.out.println(solveTopDownDP(rodLength, pieceProfit));

        System.out.println(solveBottomUp_DP(rodLength, pieceProfit));
    }

    //This recursion has time complexity : 4 ^ N
    private static int solveRecursive( int rodLength, int[] pieceProfit ) {

        if (rodLength == 0)
            return 0;

        int best = 0;

        for (int length = 1; length <= rodLength; length++) {

            //           put cut at rod on position one + tell recursion to find of rest through recursion.
            int netProfit = pieceProfit[length] + solveRecursive(rodLength - length, pieceProfit);

            best = Math.max(best, netProfit);
        }

        return best;
    }

    //Our STATE for DP is profit of rod length. So we will save RodLength in DP array.
    //Time complexity : O ( N ^ 2 )
    //Finding Piece[i th] max. profit is : O ( N ) and finding cost of 'N' pieces is O ( N * N )
    private static int solveTopDownDP( int rodLength, int[] pieceProfit ) {

        if (rodLength == 0)
            return 0;

        int best = 0;

        if (memo[rodLength] != -1)
            return memo[rodLength];

        for (int length = 1; length <= rodLength; length++) {

            //           put cut at rod on position one + tell recursion to find of rest through recursion.
            int netProfit = pieceProfit[length] + solveRecursive(rodLength - length, pieceProfit);

            best = Math.max(best, netProfit);
        }

        memo[rodLength] = best;

        return best;
    }


    //Time Complexity : O ( M * N )
    private static int solveBottomUp_DP( int rodLength, int[] pieceProfit ) {

        int dp[] = new int[100];

        for (int length = 1; length <= rodLength; length++) { //this loop is same as above recursion loop


            int best = 0;
            //For length=2: We first put a cut at length = 1 and then length = 2; then Max(length_1, length_2)
            for (int cut = 1; cut <= length; cut++) {

                //                    current cut      + remaining cut from dp array
                best = Math.max(best, pieceProfit[cut] + dp[length - cut]);
            }

            //putting best cut piece profit in dp array.
            dp[length] = best;
        }

        return dp[rodLength];
    }
}

