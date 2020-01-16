package com.interview.hackerrank.basicPractice;

import java.util.Scanner;

/*

Don't create the grid. Think mathematically. Each of the diagonal lines has to have either a slope of 1 or -1.
The horizontal lines require that the y value be the same and the vertical lines require that the x value be
the same.

So all that is needed is to keep track of the obstacles that are either on the horizontal or vertical axis of
the queen or that have on a diagonal with a slope of -1 or 1. So, if the absolute value of |x_q - x_o| = |y_q - y_o|
(where *_q represents the points for the queen and *_o represents the points for the obstacle) the queen will run into
the obstacle on the diagonal line.

So maintain eight min variables each representing the direction the queen can go. Initialize each of the eight
variables with the queen's position to the edge of the board.

Next compare each of the obstacles to see if it lies in the queen's path. If it lies in the path then
calculate the distance from the queen to the obstacle and if the distance is less than the min distance for
that direction then replace min distance with the new distance. If min distance for one direction equals zero
then you can ignore any obstacles in that direction.

Once you have parsed through the obstacles then just add up the eight min distances for the answer.

 */
public class QueensAttack2 {

    /*public static void main( String[] args ) {
        //code link : https://github.com/RyanFehr/HackerRank/blame/bdec63d3accaed7dbb16f62d389b79fad6e04fa9/Algorithms/Implementation/Queen's%20Attack%20II/Solution.java#L53
    }*/

    public static void Main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] tokens_n = scanner.next().split(" ");

        int n = Integer.parseInt(tokens_n[0]);
        int k = Integer.parseInt(tokens_n[1]);

        String[] tokens_rQueen = scanner.next().split(" ");
        int rQueen = Integer.parseInt(tokens_rQueen[0]);
        int cQueen = Integer.parseInt(tokens_rQueen[1]);

        //Calculate the distances between Queen and edge of board in all directions
        int barrier_above = n - rQueen;
        int barrier_below = rQueen-1;
        int barrier_right = n - cQueen;
        int barrier_left = cQueen-1;

        int barrier_up_right = n - Math.max(rQueen, cQueen);
        int barrier_down_right = Math.min(n-cQueen, rQueen-1);
        int barrier_up_left = Math.min(n-rQueen, Math.abs(1-cQueen));
        int barrier_down_left = Math.min(rQueen, cQueen) - 1;

        for(int a0 = 0; a0 < k; a0++){
            String[] tokens_rObstacle = scanner.next().split(" ");

            int rObstacle = Integer.parseInt(tokens_rObstacle[0]);
            int cObstacle =  Integer.parseInt(tokens_rObstacle[1]);

            //Check if obstacle is in-line with Queens in all directions
            //If in-line, check if distance between them is less than the current distance
            if( (cObstacle == cQueen && rObstacle > rQueen) && rObstacle - rQueen < barrier_above){
                barrier_above = rObstacle - rQueen-1;
            }
            else if( (cObstacle == cQueen && rObstacle < rQueen) && rQueen - rObstacle < barrier_below){
                barrier_below = rQueen - rObstacle -1;
            }
            else if( (rObstacle == rQueen && cObstacle < cQueen) && cQueen - cObstacle < barrier_left){
                barrier_left = cQueen - cObstacle -1;
            }
            else if( (rObstacle == rQueen && cObstacle > cQueen) && cObstacle - cQueen < barrier_right){
                barrier_right = cObstacle - cQueen -1;
            }
            else if( (rObstacle > rQueen && cObstacle > cQueen) && (rObstacle-rQueen == cObstacle-cQueen) &&
                    rObstacle - rQueen < barrier_up_right){
                barrier_up_right = rObstacle - rQueen -1;
            }
            else if( (rObstacle < rQueen && cObstacle < cQueen) && (rQueen-rObstacle == cQueen-cObstacle) &&
                    rQueen - rObstacle < barrier_down_left){
                barrier_down_left = rQueen - rObstacle -1;
            }
            else if( (rObstacle < rQueen && cObstacle > cQueen) && (rQueen-rObstacle == cObstacle-cQueen) &&
                    rQueen-rObstacle < barrier_down_right){
                barrier_down_right = rQueen-rObstacle -1;
            }
            else if( (rObstacle > rQueen && cObstacle < cQueen) && (rObstacle-rQueen == cQueen-cObstacle) &&
                    rObstacle-rQueen < barrier_up_left){
                barrier_up_left = rObstacle-rQueen -1;
            }
        }

        //Sum up the distances between Queen and barriers in all directions
        int sum = barrier_above + barrier_below + barrier_right + barrier_left +
                barrier_up_left + barrier_up_right + barrier_down_left + barrier_down_right;

        System.out.println(sum);
    }

}
