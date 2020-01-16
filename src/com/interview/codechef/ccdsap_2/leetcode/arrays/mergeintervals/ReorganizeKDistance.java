package com.interview.codechef.ccdsap_2.leetcode.arrays.mergeintervals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://www.programcreek.com/2014/08/leetcode-rearrange-string-k-distance-apart-java/
public class ReorganizeKDistance {

    //almost similar to ReorganizeString -> codechef.ccdsapfoundation_1 -> sorting
    public static void main( String[] args ) {
        String str = "aabbcc";
        int k = 3; //op : abcabc

        System.out.println(rearrangeString(str, k));
    }

    private static String rearrangeString( String str, int k ) {
        if (k == 0)
            return str;

        //initialize the counter for each character
        final HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        //sort the chars by frequency
        PriorityQueue<Character> queue = new PriorityQueue<>(( c1, c2 ) -> {
            if (map.get(c2).intValue() != map.get(c1).intValue()) {
                return map.get(c2) - map.get(c1); //descending order of frequency
            } else {
                return c1.compareTo(c2); //ascending order of character
            }
        });

        for (char c : map.keySet())
            queue.offer(c);

        StringBuilder sb = new StringBuilder();

        int len = str.length();

        while (!queue.isEmpty()) {

            int cnt = Math.min(k, len);
            ArrayList<Character> temp = new ArrayList<>();

            for (int i = 0; i < cnt; i++) {
                if (queue.isEmpty())
                    return "";

                //removing will return next unique character
                char c = queue.poll();
                sb.append(String.valueOf(c));

                map.put(c, map.get(c) - 1);

                //storing removed chars of PQ in temp list;
                if (map.get(c) > 0) {
                    temp.add(c);
                }

                //updating string length
                len--;
            }

            //restoring removed chars..
            for (char c : temp)
                queue.offer(c);
        }

        return sb.toString();
    }
}
