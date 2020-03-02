package com.interview.companies.amazon;

import java.util.HashSet;
import java.util.Set;

public class SubStringSizeKWithKDistimctChars {

    //https://leetcode.com/discuss/interview-question/370112
    //Given a string s and an int k, return all unique substrings of s of size k with k distinct characters.

    //Input: s = "abcabc", k = 3
    //Output: ["abc", "bca", "cab"]

    //Sliding window approach will be same as SubArrayWithKDiffIntegers
    public static void main( String[] args ) {
        getSubstrings("abcabc", 3).forEach(System.out::println);
    }

    //Time O(N * K)
    private static Set<String> getSubstrings( String s, int k ) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < s.length() - k + 1; i++) {

            StringBuilder sb = new StringBuilder();

            for (int j = i; j < i + k; j++) {

                //if character already exist in String
                if (sb.length() > 0 && sb.indexOf(s.charAt(j) + "") != -1) {
                    break;
                } else {
                    sb.append(s.charAt(j));
                }
            }

            if (sb.length() == k) {
                set.add(sb.toString());
            }
        }

        return set;

    }
}
