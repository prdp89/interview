package com.interview.hackerrank.basicPractice;

public class TimeConversion {

    //https://www.hackerrank.com/challenges/time-conversion/problem?h_r=next-challenge&h_v=zen
    private static void solve() {

        String s = "11:60:00PM";
        String op;

        String[] arr = s.split(":");

        int hours = Integer.parseInt(arr[0]);
        int mins = Integer.parseInt(arr[1]);

        int index = arr[2].indexOf('M');
        int secs = Integer.parseInt(arr[2].substring(0, index - 1)); //  Integer.parseInt(arr[2]);

        if (hours == 12 && arr[2].charAt(index - 1) == 'A') {
            //op = "00:00:00";

            op = "00:" + (mins < 10 ? "0" + mins : mins) + ":" + (secs < 10 ? "0" + secs : secs);
        } else {
            if (arr[2].contains("PM")) {
                hours += 12;
            }

            if (secs > 59) {
                mins += 1;
                secs = secs - 60;
            }

            if (mins > 59) {
                mins = mins - 60;
                hours += 1;
            }

            if (hours > 24) {
                hours += hours - 24;
            }

            op = hours + ":" + (mins < 10 ? "0" + mins : mins) + ":" + (secs < 10 ? "0" + secs : secs);
        }

        System.out.println(op);

        //System.out.println(arr[2].contains("PM"));
        //System.out.println( Integer.parseInt(arr[0]));
    }

    public static void main( String[] args ) {
        solve();
    }
}
