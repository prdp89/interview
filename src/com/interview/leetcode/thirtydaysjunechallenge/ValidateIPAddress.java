package com.interview.leetcode.thirtydaysjunechallenge;

import java.util.regex.Pattern;

public class ValidateIPAddress {

    private static String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
    private static Pattern pattenIPv4 =
            Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");
    private static String chunkIPv6 = "([0-9a-fA-F]{1,4})";
    private static Pattern pattenIPv6 =
            Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");

    //https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3362/
    public static void main( String[] args ) {
        String str = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        System.out.println(validIPAddress(str));
    }

    private static String validIPAddress( String IP ) {
        if (pattenIPv4.matcher(IP).matches()) return "IPv4";
        return (pattenIPv6.matcher(IP).matches()) ? "IPv6" : "Neither";
    }
}
