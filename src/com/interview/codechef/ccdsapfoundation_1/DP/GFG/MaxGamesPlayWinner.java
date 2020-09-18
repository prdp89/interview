package com.interview.codechef.ccdsapfoundation_1.DP.GFG;

public class MaxGamesPlayWinner {

    //https://www.geeksforgeeks.org/maximum-games-played-winner/
    public static void main( String[] args ) {
        System.out.println(maxGamesPlayedWinner(4));
    }

    private static int maxGamesPlayedWinner( int n ) {

        if (n <= 1) return 0;

        if (n % 2 != 0) //if total player is 3 then n-1 players will play
            return 1 + maxGamesPlayedWinner(n - 1);

        return 1 + maxGamesPlayedWinner(n / 2);
    }
}
