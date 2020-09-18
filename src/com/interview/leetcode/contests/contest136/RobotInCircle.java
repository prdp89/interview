package com.interview.leetcode.contests.contest136;

public class RobotInCircle {

    //https://leetcode.com/contest/weekly-contest-136/problems/robot-bounded-in-circle/
    public static void main( String[] args ) {
        String str = "GGLLGG";
        //System.out.println(solve(str));
        System.out.println(isRobotBounded_optimal(str));
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

    //Runtime: 0 ms, faster than 100.00% of Java
    //https://leetcode.com/problems/robot-bounded-in-circle/discuss/850969/My-Java-Solution-with-the-thought-process
    private static boolean isRobotBounded_optimal( String instructions ) {
        if (instructions.length() == 0)
            return false;

        int x = 0;
        int y = 0;  // initial points of the robot
        String directions = "North"; // initial direction of robot
        /*
                    North
            West                East
                    South

        */
        for (char ch : instructions.toCharArray()) {
            if (ch == 'G') {
                if (directions.equals("North"))
                    y += 1;
                else if (directions.equals("South"))
                    y -= 1;
                else if (directions.equals("East"))
                    x += 1;
                else
                    x -= 1;
            } else if (ch == 'L') {
                if (directions.equals("North"))
                    directions = "West";
                else if (directions.equals("West"))
                    directions = "South";
                else if (directions.equals("South"))
                    directions = "East";
                else directions = "North";
            } else if (ch == 'R') {
                if (directions.equals("North"))
                    directions = "East";
                else if (directions.equals("East"))
                    directions = "South";
                else if (directions.equals("South"))
                    directions = "West";
                else directions = "North";
            }
        }

        if (x == 0 && y == 0)
            return true;

        if (directions.equals("North"))
            return false;

        return true;
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
