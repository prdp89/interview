package com.interview.codingblocks.week9DynamicProgrammming;

/*
N frinds going to party.They can either go in pair or single.
If n = 3 {1, 2, 3} then they can go in :
         (1), (2,3)
         (1,2) (3)
         (1,3) (2)
         (1) (2) (3)
         total 4 ways are possible
 */

//https://www.geeksforgeeks.org/friends-pairing-problem/

import java.util.Scanner;

public class FriendsPairing {

    public static void main( String[] args ) {
      //  System.out.println(solveRecursive(3));

        Scanner scanner = new Scanner(System.in);

        System.out.println(countFriendsPairings(scanner.nextInt()));
    }

    /*
     {1, 2, 3}

     Two cases : exclude the friend & include the friend

     1.) If last friend '3' goes alone, then remaining is ( n - 1 ) friends. They can go in F(n-1) ways.
         E.g : If '3' goes away then recur for {1,2} means : (1,2) go in pair or (1) go single or (2) go single

     2.) If the last friend '3' want to go in pair. Then he can make pair in ( n - 1 ) ways.
         E.g : (3,1) (3,2) and, Also the remaining n - 2 persons can further pair up in f(n - 2) ways.
So       it is (n - 1)*f(n - 2).

     */
    private static int solveRecursive( int n ) {

        if (n <= 1)
            return 1;

        int pair = solveRecursive(n - 1) +
                (n - 1) * solveRecursive(n - 2);

        return pair;

    }

    private static int countFriendsPairings( int n ) {
        int dp[] = new int[n + 1];

        // Filling dp[] in bottom-up manner using
        // recursive formula explained above.
        for (int i = 1; i <= n; i++) {

            //1 friend can go in 1 and 2 in 2 ways
            if (i <= 2)
                dp[i] = i;
            else
                dp[i] = dp[i - 1] + (i - 1)
                        * dp[i - 2];
        }

        return dp[n];
    }
}
