package com.interview.leetcode.contests.biweekly.biweekely33;

public class ThousandSeparator {


    public static void main( String[] args ) {
        int n = 1234;

        System.out.println(thousandSeparator(n));
    }

    public static String thousandSeparator( int n ) {
        String str = n + "";

        if (str.length() <= 3)
            return str;

        StringBuilder sb = new StringBuilder(str);

        int i = str.length() - 1, j = 1;
        while (i > 0) {

            if (j == 3) {
                sb.insert(i, ".");
                j = 0;
            }

            i--;
            j++;
        }

        return sb.toString();
    }
}
