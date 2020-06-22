package com.interview.leetcode.Arrays.twopointers;

import java.util.Arrays;

public class BagOfTokens {

    //https://leetcode.com/problems/bag-of-tokens/

    //we can sell token[i] and gain 1 points.
    //we can sell points to gain token[length -1] power.

    //Means, Buy at cheap, sell at expensive.
    public static void main( String[] args ) {
        int[] tokens = {100, 200, 300, 400};
        int p = 200;
        System.out.println(bagOfTokensScore(tokens, p));
    }

    //Almost think of it, implemented with little help
    //Runtime: 3 ms, faster than 81.47% of Java
    private static int bagOfTokensScore( int[] tokens, int P ) {
        Arrays.sort(tokens);

        int points = 0, i = 0, j = tokens.length - 1, maxPoints = 0;

        while (i <= j) {

            if (tokens[i] <= P) {
                points++;
                P -= tokens[i];

                maxPoints = Math.max(maxPoints, points);
                i++;
            } else if (points > 0) //we have some points
            {
                points--; //sell the points
                P += tokens[j]; //pick greedily
                j--;
            } else {
                break;
            }
        }

        return maxPoints;
    }
}
