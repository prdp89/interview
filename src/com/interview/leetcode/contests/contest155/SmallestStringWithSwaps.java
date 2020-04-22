package com.interview.leetcode.contests.contest155;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestStringWithSwaps {

    //This question is originally based on :
    //https://www.programcreek.com/2014/05/leetcode-number-of-connected-components-in-an-undirected-graph-java/
    //Number of Connected components in Undirected graph.
    //Then for optimal sol., follow this:
    // https://leetcode.com/problems/smallest-string-with-swaps/discuss/387785/Faster-than-100.-Concise-Java-Solution.-Connected-Components.

    //https://leetcode.com/contest/weekly-contest-155/problems/smallest-string-with-swaps/
    public static void main( String[] args ) {
        String str = "dcab";

        List<List<Integer>> listList = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(3);

        listList.add(list);

        list = new ArrayList<>();
        list.add(1);
        list.add(2);

        listList.add(list);

        list = new ArrayList<>();
        list.add(0);
        list.add(2);

        listList.add(list);

        smallestStringWithSwaps(str, listList);
    }

    //4 / 36 test cases passed.
    private static String smallestStringWithSwaps( String s, List<List<Integer>> pairs ) {

        pairs.sort(Comparator.comparing(a -> a.get(0)));

        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.naturalOrder());

        pq.offer(s);

        for (List<Integer> pair : pairs) {
            String str = swap(pair.get(0), pair.get(1), new StringBuilder(s));
            pq.offer(str);
            s = str;
        }

        return pq.peek();
    }

    private static String swap( Integer integer, Integer integer1, StringBuilder s ) {
        char temp = s.charAt(integer);
        s.setCharAt(integer, s.charAt(integer1));
        s.setCharAt(integer1, temp);
        return s.toString();
    }
}
