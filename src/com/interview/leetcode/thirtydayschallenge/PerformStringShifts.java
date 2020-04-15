package com.interview.leetcode.thirtydayschallenge;

public class PerformStringShifts {

    //https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3299/
    public static void main( String[] args ) {
        String s = "mecsk";
        int[][] shift = {{1, 4},
                {0, 5},
                {0, 4},
                {1, 1},
                {1, 5}};

        System.out.println(stringShift(s, shift));

        System.out.println("optimal:" + stringShiftOptimal(s, shift));
    }

    /*
    31 / 31 test cases passed.
    Status: Accepted
    Runtime: 1 ms
     */
    private static String stringShift( String s, int[][] shift ) {

        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < shift.length; i++) {

            int direction = shift[i][0];
            int amount = shift[i][1];

            //if string length == rotation then no changes needed..
            if (amount == s.length())
                continue;

            if (direction == 0)
                sb = new StringBuilder(sb.substring(Math.min(amount, s.length() - 1))
                        + sb.substring(0, amount));
            else {
                sb = new StringBuilder(sb.substring(sb.length() - amount, sb.length()) +

                        sb.substring(0, sb.length() - amount)
                );
            }
        }

        return sb.toString();
    }

    /*
    31 / 31 test cases passed.
    Status: Accepted
    Runtime: 0 ms
    Memory Usage: 37.8 MB
     */
    private static String stringShiftOptimal( String s, int[][] shift ) {
        StringBuilder sb = new StringBuilder(s);

        int total = 0;
        for (int[] aShift : shift) {

            int direction = aShift[0];
            int amount = aShift[1];


            if (direction == 0) {
                total += amount;
            } else {
                total -= amount;
            }
        }

        int n = s.length();
        total = total % n;
        if (total < 0) {
            total += n;
        }

        return sb.substring(total) + sb.substring(0, total);
    }
}