package com.interview.companies.fb;

public class FractionToRecurringDecimal {

    //https://leetcode.com/problems/fraction-to-recurring-decimal/
    public static void main( String[] args ) {
        int numerator = 1, denominator = 8;
        System.out.println(fractionToDecimal(numerator, denominator));
    }

    //lot of hard work put; able to pass: 21 / 37 test cases passed.
    private static String fractionToDecimal( int numerator, int denominator ) {

        if (numerator > denominator)
            return String.valueOf(numerator / denominator);

        double db = (double) numerator / denominator;

        String str = db + "";

        String[] strings = str.split("\\.");

        if (strings[1].length() == 1)
            return strings[0] + "." + strings[1];

        String repeat = strings[1];
        int index = -1;

        int i = 0;

        while (index == -1 && i < repeat.length()) {
            index = repeat.indexOf(repeat.charAt(i), ++i);
        }

        String firstPart = strings[0] + ".";

        if (index == -1)
            return firstPart + repeat;

        String secondPart = repeat.substring(0, i - 1) + "(" + repeat.substring(i - 1, index) + ")";

        return firstPart + secondPart;
    }
}
