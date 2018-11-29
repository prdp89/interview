package com.interview.hackerrank.recursion;

public class ChangePi {

    //https://codingbat.com/prob/p170924
    public static void main( String[] args ) {
        //System.out.println(solve("pip"));

        System.out.println(changePi("pip"));

    }

    public static String solve( String str ) {

        if (str.length() == 0)
            return "";

        String string = (str.charAt(str.length() - 1) == 'i' &&
                str.length() - 2 >= 0 &&
                str.charAt(str.length() - 2) == 'p' ? "3.14" :
                str.charAt(str.length() - 1) + "");

        string += solve(str.substring(0, str.length() - (string.length() > 1 ? 2 : 1)));
        return string;
    }

    //passes all test case
    private static String changePi( String str ) {
        if (str.equals("") || str.length() < 2)
            return str;

        if (str.charAt(0) == 'p' && str.charAt(1) == 'i')
            return "3.14" + changePi(str.substring(2));

        return str.charAt(0) + changePi(str.substring(1));
    }

}
