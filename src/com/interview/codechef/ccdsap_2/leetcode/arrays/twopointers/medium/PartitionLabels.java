package com.interview.codechef.ccdsap_2.leetcode.arrays.twopointers.medium;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    //https://leetcode.com/problems/partition-labels/
    public static void main( String[] args ) {
        String str = "ababcbacadefegdehijhklij";

        solveTry(str).forEach(System.out::println);
    }

    //The logic is similar to mergeIntervals : com.interview.codechef.ccdsap_2.leetcode.arrays.mergeintervals -> MergeIntervals
    private static List<Integer> solveTry( String str ) {

        if (str == null || str.length() == 0) {
            return null;
        }

        List<Integer> list = new ArrayList<>();

        int[] map = new int[26];

        // record the last index of the each char
        for (int i = 0; i < str.length(); i++) {
            map[str.charAt(i) - 'a'] = i;
        }

        //This part is similar to merge interval
        int last = 0;
        int start = 0;

        for (int i = 0; i < str.length(); i++) {

            //str.charAt(i) - 'a' : returns character from {0--25}
            //Then we are getting that character last index{finding max out of it}
            last = Math.max(last, map[str.charAt(i) - 'a']);

            //if that character last index matches current; means we can partition here..
            if (last == i) {
                list.add(last - start + 1);

                //updating start to last character to find next substring
                start = last + 1;
            }
        }

        return list;
    }
}
