package com.interview.errichto.easy.arrays;

public class AngleinClock {

    public static void main( String[] args ) {

    }

    /*
    Total clock = 360 degrees
    12 gap in a clock, so each 5 minute gap = 30 degree

    5 min = 30 degree so 1 min = 30/5 => 6 degree

    -> When hour hand move for 60 minutes it covers 30 degree. So 60 min = 30 degree
       When hour hand move for 1 minute it covers = 30/60 = 0.5 degree
     */
    private static double angleClock( int hour, int minutes ) {
        double a1 = 360 * (minutes / 60.0);

        double a2 = 360 * (hour / 12.0) + 30 * (minutes / 60.0);

        double result = Math.abs(a1 - a2);

        if (result > 180.0) {
            result = 360.0 - result;
        }

        return result;
    }
}
