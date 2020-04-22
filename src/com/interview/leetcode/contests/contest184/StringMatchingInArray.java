package com.interview.leetcode.contests.contest184;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class StringMatchingInArray {

    //https://leetcode.com/contest/weekly-contest-184/problems/string-matching-in-an-array/
    public static void main( String[] args ) {
        String[] strings = {"mass", "as", "hero", "superhero"};
        stringMatching(strings).forEach(System.out::println);
    }

    private static List<String> stringMatching( String[] words ) {
        HashSet<String> set = new HashSet<>();

        List<String> list = new ArrayList<>();

        set.addAll(Arrays.asList(words));

        for (String str : words) {

            set.forEach(item -> {
                if (!str.equals(item) && str.contains(item)) {
                    if (!list.contains(item)) list.add(item);
                } /*else if (!item.equals(str) && item.contains(str))
                    if (!list.contains(str)) list.add(str);*/
            });
        }

        return list;
    }
}
