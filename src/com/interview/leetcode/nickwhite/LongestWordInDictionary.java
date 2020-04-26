package com.interview.leetcode.nickwhite;

import java.util.Arrays;
import java.util.HashSet;

public class LongestWordInDictionary {

    //https://leetcode.com/problems/longest-word-in-dictionary/
    public static void main( String[] args ) {
        String[] strings = {"w", "wo", "wor", "worl", "world"};
        System.out.println(longestWord(strings));
    }

    //Runtime: 12 ms, faster than 75.22% of Java
    private static String longestWord( String[] words ) {
        Arrays.sort(words, ( a, b ) -> {

            if (a.length() != b.length())
                return b.length() - a.length();
            else
                return a.compareTo(b);
        });

        HashSet<String> hashSet = new HashSet<>(Arrays.asList(words));

        for (String str : words) {

            int count = 0;

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < str.length(); j++) {
                sb.append(str.charAt(j));
                if (hashSet.contains(sb.toString()))
                    count++;
                else
                    break;
            }

            if (count == str.length())
                return str;
        }

        return "";
    }
}
