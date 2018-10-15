package com.interview.hackerrank.basicPractice;

public class TheTimeInWords {

    private static String solve() {
        String[] number = {
                "zero",
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine",
                "ten",
                "eleven",
                "twelve",
                "thirteen",
                "fourteen",
                "fifteen",
                "sixteen",
                "seventeen",
                "eighteen",
                "nineteen",
                "twenty",
                "twenty one",
                "twenty two",
                "twenty three",
                "twenty four",
                "twenty five",
                "twenty six",
                "twenty seven",
                "twenty eight",
                "twenty nine"
        };

        int h, m;

        h = 5;
        m = 0;

        if (m == 0)
            return number[h] + " o' clock";
        else if (m == 15)
            return "quarter past " + number[h];
        else if (m == 30)
            return "half past " + number[h];
        else if (m > 0 && m < 30)
            return number[m] + (m == 1 ? " minute past " : " minutes past ") + number[h];
        else if (m == 45)
            return "quarter to " + number[h + 1];
        else if (m > 30 && m < 60)
            return number[60 - m] + (60 - m == 1 ? " minute to " : " minutes to ") + number[h + 1];

        return "";

    }

    public static void main( String[] args ) {

        System.out.println(solve());
    }
}
