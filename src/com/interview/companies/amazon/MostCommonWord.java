package com.interview.companies.amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MostCommonWord {

    //https://leetcode.com/problems/most-common-word/
    public static void main( String[] args ) {

        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned[] = {"hit"};

        System.out.println(mostCommonWord(paragraph, banned));
    }

    private static String mostCommonWord( String paragraph, String[] banned ) {

        String[] split = paragraph.toLowerCase().split("\\W+");

        Set<String> set = new HashSet<>();
        for (String str : banned) {
            set.add(str);
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (String str : split) {
            if (!set.contains(str.trim()))
                map.put(str, map.getOrDefault(str, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        String temp = "";
        for (String value : map.keySet()) {
            if (map.get(value) > max) {
                max = map.get(value);
                temp = value;
            }
        }

        return temp;
    }
}
