package com.interview.hackerrank.recursion;

public class StringDistinct {

    public static void main( String[] args ) {
        System.out.println(strDist("cccatcowcatxx", "cat"));
    }

    private static int strDist( String str, String sub ) {

        if (str.length() < sub.length())
            return 0;

        //comparing if : first 3 chars equals "cat"
        //          and : last 3 chars equals "cat"
        if (str.substring(0, sub.length()).equals(sub) &&
                str.substring(str.length() - sub.length()).equals(sub))
            return str.length();

        //otherwise if : first 3 chars not equals "cat" : increase string to 1 char ahead
        if (!str.substring(0, sub.length()).equals(sub))
            return strDist(str.substring(1), sub);

        //decrease the string parallely from end with 1 char to match with sub.
        return strDist(str.substring(0, str.length() - 1), sub);
    }
}
