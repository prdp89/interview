package com.interview.leetcode.contests.contest177;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DaysBetweenDate {

    //https://leetcode.com/contest/weekly-contest-177/problems/number-of-days-between-two-dates/
    public static void main( String[] args ) {
        System.out.println(solve("2020-01-15", "2019-12-31"));
    }

    //look at this too: https://leetcode.com/problems/number-of-days-between-two-dates/discuss/517575/Java-no-time-api-cheating
    private static int solve( String date1, String date2 ) {

        String[] tempDate1 = date1.split("-");
        LocalDate dateTime = LocalDate.of(Integer.parseInt(tempDate1[0]),
                Integer.parseInt(tempDate1[1]),
                Integer.parseInt(tempDate1[2]));


        String[] tempDate2 = date2.split("-");
        LocalDate dateTime2 = LocalDate.of(Integer.parseInt(tempDate2[0]),
                Integer.parseInt(tempDate2[1]),
                Integer.parseInt(tempDate2[2]));

        return Math.abs((int) ChronoUnit.DAYS.between(dateTime, dateTime2));
    }
}
