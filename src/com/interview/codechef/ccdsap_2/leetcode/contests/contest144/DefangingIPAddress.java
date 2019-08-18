package com.interview.codechef.ccdsap_2.leetcode.contests.contest144;

public class DefangingIPAddress {

    //https://leetcode.com/contest/weekly-contest-144/problems/defanging-an-ip-address/
    public static void main( String[] args ) {
        String str = "255.100.50.0";

        StringBuilder sb = new StringBuilder(str);
        System.out.println(solveTry(sb, 0));
    }

    //passed in one go
    private static String solveTry( StringBuilder str, int i ) {

        if (i == str.length()) {
            return str.toString();
        }

        if (str.charAt(i) == '.') {
            str.replace(i, i + 1, "[.]");
            return solveTry(str, i + 3);
        }

        return solveTry(str, i + 1);
    }

    private String defangIPaddr( String address ) {
        return address.replace(".", "[.]");
    }
}
