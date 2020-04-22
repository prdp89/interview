package com.interview.companies.google;

import java.util.HashSet;

public class UniqueEmailAddress {

    //https://leetcode.com/problems/unique-email-addresses/
    public static void main( String[] args ) {
        //String str[] = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        String str[] = {"test.email+alex@leetcode.com", "test.email@leetcode.com"};

        System.out.println(numUniqueEmails(str));
    }

    //Runtime: 7 ms, faster than 84.61% of Java
    private static int numUniqueEmails( String[] emails ) {
        HashSet<String> set = new HashSet<>();

        for (String str : emails) {

            StringBuilder sb = new StringBuilder();
            boolean isAtFound = false; //stop ignoring . after @ char
            for (int i = 0; i < str.length(); i++) {

                if (str.charAt(i) == '+') {
                    int j = str.indexOf('@');

                    while (i++ <= j) ;

                    sb.append(str.substring(j));
                    break;
                } else if (isAtFound || str.charAt(i) != '.') {

                    if (str.charAt(i) == '@')
                        isAtFound = true;

                    sb.append(str.charAt(i));
                }
            }

            set.add(sb.toString());
        }

        return set.size();
    }
}
