package com.interview.codingblocks.week9DynamicProgrammming;

import java.util.Arrays;
import java.util.Scanner;

public class RockPaperScissor {

    /*
    Paper–scissors-rock is a hand game usually played between two people,
    in which each player simultaneously forms one of three shapes with an outstretched hand.
    These shapes are "rock", "paper", and "scissors".

         beat          beat         beat
    Rock ----> scissor ----> paper -------> Rock

    Given N and each test case contain values of : Rock, Scissor and Paper:

    Input:
    3
    2 2 2
    2 1 2
    1 1 3

    Output:
    0.33333  0.33333  0.33333 [since input is {2,2,2} probability output of occurring rock, scissor and paper is same]

    0.15000  0.30000  0.55000 [output values calculated according to winning probability]

    0.05714  0.65714  0.28571 [output values calculated according to winning probability]
     */

    /*
    If function represents: F(R, P, S)

    Calculating probability of Rock fight (win/lose):

    1.) If fight happens between Rock and Paper : rock loses, function is:
        F(R-1, P, S) * Probability
                       where probability = chance of fight between Rock and Paper / total number of fights
                                         = (R * P) / (R*P) + (P*S) + (S*R)

        Final Function is : F(R-1, P, S) * R*P / (R*P) + (P*S) + (S*R)

    2.) If fights between Scissor and Paper then paper loose. And Rock remain as it is, function is:
        F(R-1, P, S) * ((P*S) / (R*P) + (P*S) + (S*R))

    3.) If fight between Scissor and Rock then Rock survives and function is:
        F(R, P, S-1) ( (S * R) / (R*P) + (P*S) + (S*R) )

    And the Base case of Recursion is :

    if(R== 0 || S==0) means no Rock or Scissor left, therefore Rock cannot wins. So returns zero
        return 0;

    if(P==0) means Paper doesn't exist, so Rock can win over Scissor. So return One.
     return 1

    Addition of 1+2+3 is final probability of Rock fights.

    Similarly Probability of Scissor and Paper can be be calculated.
     */

    static double dp[][][] = new double[100][100][100];

    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        while (N-- > 0) {

            int R = scanner.nextInt();
            int S = scanner.nextInt();
            int P = scanner.nextInt();

            initDPArray();
            double rockProbablilty = rockFight(R, S, P);
            initDPArray();
            double scissorProbablilty = scissorFight(R, S, P);
            initDPArray();
            double paperProbablilty = paperFight(R, S, P);

            //0.15000  0.30000  0.55000
            System.out.println(rockProbablilty + " " + scissorProbablilty + " " + paperProbablilty);
        }
    }

    private static double paperFight( int r, int s, int p ) {

        if (p == 0 || r == 0) //means no paper or Rock left, therefore Rock cannot wins. So returns zero
            return 0;

        if (s == 0) //means Scissor doesn't exist, so Paper can win over rock. So return One.
            return 1.0;

        if (dp[r][s][p] != -1)
            return dp[r][s][p];

        double total = r * s + r * p + s * p;

        double result = 0.0;

        result += paperFight(r - 1, s, p) * ((r * p) / total); //paper kills rock; Paper wins
        result += paperFight(r, s, p - 1) * ((s * p) / total); //scissor kills paper
        result += paperFight(r, s - 1, p) * ((r * s) / total); //rock kills scissor; Paper wins

        return dp[r][s][p] = result;
    }

    private static double scissorFight( int r, int s, int p ) {

        if (p == 0 || s == 0) //means no paper or Scissor left, therefore Scissor cannot wins. So returns zero
            return 0;

        if (r == 0) //means Rock doesn't exist, so Scissor can win over Paper. So return One.
            return 1.0;

        if (dp[r][s][p] != -1)
            return dp[r][s][p];

        double total = r * s + r * p + s * p;

        double result = 0.0;

        result += scissorFight(r - 1, s, p) * ((r * p) / total); //paper kills rock; scissor wins
        result += scissorFight(r, s, p - 1) * ((s * p) / total); //scissor kills paper
        result += scissorFight(r, s - 1, p) * ((r * s) / total); //rock kills scissor

        return dp[r][s][p] = result;
    }

    private static double rockFight( int r, int s, int p ) {

        if (r == 0 || s == 0)
            return 0;

        if (p == 0)
            return 1.0;

        if (dp[r][s][p] != -1)
            return dp[r][s][p];

        double total = r * s + r * p + s * p;

        double result = 0.0;

        result += rockFight(r - 1, s, p) * ((r * p) / total); //paper kills rock
        result += rockFight(r, s, p - 1) * ((s * p) / total); //scissor kills paper
        result += rockFight(r, s - 1, p) * ((r * s) / total); //rock kills scissor

        return dp[r][s][p] = result;

    }

    private static void initDPArray() {
        for (double[][] innerRow : dp) {
            for (double[] innerInnerRow : innerRow) {
                Arrays.fill(innerInnerRow, -1);
            }
        }

    }

}
