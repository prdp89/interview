package com.interview.companies.fb;

import java.util.HashMap;
import java.util.Stack;

public class CustomSortString {

    //https://leetcode.com/problems/custom-sort-string/
    public static void main( String[] args ) {
        String s = "cba", t = "abbcd";

        System.out.println(customSortString(s, t));
    }

    //Runtime: 2 ms, faster than 43.23% of Java
    //TIME : O (N + M)
    private static String customSortString( String S, String T ) {
        Stack<Character> set = new Stack<>();

        for (int i = S.length() - 1; i >= 0; i--)
            set.add(S.charAt(i));

        HashMap<Character, Integer> map = new HashMap<>();
        for (Character ch : T.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        while (!set.isEmpty()) {
            Character ch = set.pop();
            if (map.containsKey(ch)) {
                int count = map.get(ch);
                while (count-- > 0) {
                    sb.append(ch);
                }
                map.remove(ch);
            }
        }

        if (map.size() > 0) {
            map.forEach(( k, v ) ->
                    {
                        int va = v;
                        while (va-- > 0) {
                            sb.append(k);
                        }
                    }
            );
        }

        return sb.toString();
    }

    private static String customSortStringOPtimal( String S, String T ) {
        int[] count = new int[26];
        for (char c : T.toCharArray()) {
            ++count[c - 'a'];
        }  // count each char in T.

        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            while (count[c - 'a']-- > 0) {
                sb.append(c);
            }    // sort chars both in T and S by the order of S.
        }

        //looping for pending chars..
        for (char c = 'a'; c <= 'z'; ++c) {
            while (count[c - 'a']-- > 0) {
                sb.append(c);
            }    // group chars in T but not in S.
        }

        return sb.toString();
    }
}
