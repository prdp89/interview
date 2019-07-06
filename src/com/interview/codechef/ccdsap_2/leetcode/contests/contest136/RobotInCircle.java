package com.interview.codechef.ccdsap_2.leetcode.contests.contest136;

public class RobotInCircle {

    //https://leetcode.com/contest/weekly-contest-136/problems/robot-bounded-in-circle/
    public static void main( String[] args ) {
        String str = "GGLLGG";
        System.out.println(solve(str));
    }

    private static boolean solve( String str ) {

        int x = 0, y = 0;

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == 'G') {
                y++;
            } else if (str.charAt(i) == 'L') {
                y--;
            } else if (str.charAt(i) == 'R') {
                x++;
                y++;
            }
        }
        return x == 0 && y == 0;
    }

    //ref: https://leetcode.com/problems/robot-bounded-in-circle/discuss/291116/Python-Easy-to-understand-use-complex-number-to-keep-direction
    private static boolean isRobotBounded( String instructions ) {
        int x = 0;
        int y = 0;
        char d = 'N';

        for (int i = 0; i < 4; i++) {

            //for each direction we have 4 direction to move
            for (char c : instructions.toCharArray()) {

                if (c == 'G') {
                    if (d == 'N') y++;
                    else if (d == 'E') x++;
                    else if (d == 'S') y--;
                    else if (d == 'W') x--;
                } else if (c == 'L') {
                    if (d == 'N') d = 'W';
                    else if (d == 'W') d = 'S';
                    else if (d == 'S') d = 'E';
                    else if (d == 'E') d = 'N';
                } else if (c == 'R') {
                    if (d == 'N') d = 'E';
                    else if (d == 'W') d = 'N';
                    else if (d == 'S') d = 'W';
                    else if (d == 'E') d = 'S';
                }
            }
        }
        return x == 0 && y == 0;
    }
}
