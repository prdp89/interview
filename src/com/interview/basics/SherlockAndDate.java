package com.interview.basics;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SherlockAndDate {

    public void solve() throws ParseException {
        try (PrintWriter pw = new PrintWriter(System.out, false)) {
            FastReader reader = new FastReader();
            int testCases = reader.nextInt();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM yyyy");

            while (testCases-- > 0) {
                String arr = reader.nextLine();
                final Date date = simpleDateFormat.parse(arr);

                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                cal.add(Calendar.DATE, -1);

                pw.println(simpleDateFormat.format(cal.getTime()));
            }
        }
    }

    private String calculateMonth( int month ) {
        switch (month) {
            case 0:
                return "January";
            case 1:
                return "February";
            case 2:
                return "March";
            case 3:
                return "April";
            case 4:
                return "May";
            case 5:
                return "June";
            case 6:
                return "July";
            case 7:
                return "August";
            case 8:
                return "September";
            case 9:
                return "October";
            case 10:
                return "November";
            case 11:
                return "December";
            default:
                return "January";
        }
    }

    public static void main( String args[] ) throws ParseException {
        SherlockAndDate sherlockAndDate = new SherlockAndDate();
        sherlockAndDate.solve();
    }
}

