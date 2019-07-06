package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.HashSet;

//https://leetcode.com/problems/unique-substrings-in-wraparound-string/
public class UniqueSubstring {

    //This problem is hard , couldn't solve it more...
    //just 12/81 test cases passed
    private static int subString( char[] str, int n ) {

        HashSet<String> hSet = new HashSet<>();
        for (int i = 0; i < n; i++) {

            StringBuilder c = new StringBuilder("");
            c.append(str[i]);

            for (int k = i + 1; k <= n; k++) {

                hSet.add(c.toString());

                if (k < n) {
                    c.append(str[k]);
                }
            }
        }

        String s = "zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";

        int count = 0;
        for (String str1 : hSet) {
            if (s.contains(str1))
                count++;
        }

        return count;
    }

    public static void main( String[] args ) {
        String str = "uvwxyzabcdefg";
        System.out.println(subString(str.toCharArray(), str.length()));
    }
}
