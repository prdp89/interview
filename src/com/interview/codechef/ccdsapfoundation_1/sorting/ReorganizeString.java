package com.interview.codechef.ccdsapfoundation_1.sorting;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    //https://leetcode.com/problems/reorganize-string/
    public static void main( String[] args ) {
        System.out.println(reorganizeString("aab"));
    }

    private static String reorganizeString( String S ) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);

            // Impossible to form a solution; IF occurrence of character is more than half + 1 of the length of string
            if (map.get(c) > (S.length() + 1) / 2)
                return "";
        }

        // Use PriorityQueue to store char and sort by count DESC after finding it in map.
        PriorityQueue<Character> pq = new PriorityQueue<>(( a, b ) -> map.get(b) - map.get(a));

        for (char c : map.keySet())
            pq.offer(c);

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {

            //first removed character from priority queue
            char cur = pq.poll();

            //cur != sb.charAt(sb.length() - 1) : if last inserted char on 'sb' is not the current char
            if (sb.length() == 0 || cur != sb.charAt(sb.length() - 1)) {

                sb.append(cur);

                int f1 = map.get(cur);

                if (--f1 > 0) {

                    //pq.poll : removes the item from Priority queue; If that character has more occurrence then re-insert it into priority queue
                    pq.offer(cur);

                    map.put(cur, f1);
                }
            } else {

                //polling again will definitely return different char since last poll returns same char
                char cur2 = pq.poll();

                sb.append(cur2);

                int f2 = map.get(cur2);

                if (--f2 > 0) {

                    //same as above
                    pq.offer(cur2);

                    map.put(cur2, f2);
                }

                //re-inserting the first removed char
                pq.offer(cur);
            }
        }
        return sb.toString();
    }
}
