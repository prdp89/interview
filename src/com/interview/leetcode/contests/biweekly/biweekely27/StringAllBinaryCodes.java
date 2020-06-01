package com.interview.leetcode.contests.biweekly.biweekely27;

import java.util.HashSet;
import java.util.Set;

public class StringAllBinaryCodes {

    public static void main( String[] args ) {
        String s = "00110110";
        int k = 2;

        System.out.println(hasAllCodes(s, k));

        System.out.println(hasAllCodes_OPtimal(s, k));
    }

    //Passed almost all test cases TLE
    private static boolean hasAllCodes( String s, int k ) {
        int num = 2 << k - 1;

        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i < num; i++) {
            set.add((long) i);
        }

        for (int i = 0; i < s.length(); i++) {

            //if (i + k < s.length())
            {
                String str = s.substring(i, Math.min(i + k, s.length()));

                if (str.length() == k) {
                    long a = Long.parseLong(str, 2);

                    if (set.contains(a))
                        set.remove(a);
                }

            }

            //if (set.isEmpty())
            //  return true;
        }

        return set.size() == 0;
    }

    //Runtime: 125 ms, faster than 33.33% of Java
    private static boolean hasAllCodes_OPtimal( String s, int k ) {
        Set<String> set = new HashSet<>();

        if (s.length() - k < 0)
            return false;

        for (int i = 0; i <= s.length() - k; i++)
            set.add(s.substring(i, i + k));

        return set.size() == Math.pow(2, k);
    }
}
