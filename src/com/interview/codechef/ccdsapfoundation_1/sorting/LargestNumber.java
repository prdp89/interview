package com.interview.codechef.ccdsapfoundation_1.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    //https://leetcode.com/problems/largest-number/
    public static void main( String[] args ) {
        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
    }

    /*
    The idea here is basically implement a String comparator to decide which String should come first
    during concatenation. Because when you have 2 numbers (let's convert them into String), you'll face only 2 cases:

    For example:

    String s1 = "9";
    String s2 = "31";

    String case1 =  s1 + s2; // 931
    String case2 = s2 + s1; // 319

     */
    private static String largestNumber( int[] num ) {
        if (num == null || num.length == 0)
            return "";

        // Convert int array to String array, so we can sort later on
        String[] s_num = new String[num.length];
        for (int i = 0; i < num.length; i++)
            s_num[i] = String.valueOf(num[i]);

        // Comparator to decide which string should come first in concatenation
        Comparator<String> comp = ( str1, str2 ) -> {
            String s1 = str1 + str2;
            String s2 = str2 + str1;
            return s2.compareTo(s1); // reverse order here, so we can do append() later
        };

        //or---------------
        //Arrays.sort(s_num, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        Arrays.sort(s_num, comp);

        // An extreme edge case by lc, say you have only a bunch of 0 in your int array
        if (s_num[0].charAt(0) == '0')
            return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : s_num)
            sb.append(s);

        return sb.toString();
    }
}
