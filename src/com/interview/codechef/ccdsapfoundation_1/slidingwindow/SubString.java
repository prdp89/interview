package com.interview.codechef.ccdsapfoundation_1.slidingwindow;

public class SubString {

    //https://www.geeksforgeeks.org/program-print-substrings-given-string/
    public static void main( String[] args ) {
        char[] ar = {'a', 'b', 'c'};
        subString(ar, ar.length);
    }

    private static void subString( char[] str, int n ) {

        for (int i = 0; i < n; i++) {

            StringBuffer c = new StringBuffer("");
            c.append(str[i]);

            for (int k = i + 1; k <= n; k++) {

                System.out.println(c);

                if (k < n) {
                    c.append(str[k]);
                }
            }
        }
    }
}
