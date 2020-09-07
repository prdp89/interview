package com.interview.leetcode.design;

import java.util.PriorityQueue;

public class IteratorCombination {

    private PriorityQueue<String> pq;

    private IteratorCombination( String characters, int combinationLength ) {
        pq = new PriorityQueue<>();
        dfs(0, characters, new StringBuilder(), combinationLength);
    }

    //https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3422/
    public static void main( String[] args ) {
        IteratorCombination iterator = new IteratorCombination("abc", 2);

        System.out.println(iterator.next()); // returns "ab"
        iterator.hasNext(); // returns true

        System.out.println(iterator.next()); // returns "ac"
        iterator.hasNext(); // returns true

        System.out.println(iterator.next()); // returns "bc"
        iterator.hasNext(); // returns false
    }

    private void dfs( int start, String str, StringBuilder sb, int k ) {
        if (k == 0) {
            pq.offer(sb.toString());
        }

        for (int i = start; i < str.length(); i++) {
            dfs(i + 1, str, sb.append(str.charAt(i)), k - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public String next() {
        return pq.poll();
    }

    public boolean hasNext() {
        return !pq.isEmpty();
    }
}
