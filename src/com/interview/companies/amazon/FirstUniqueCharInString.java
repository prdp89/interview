package com.interview.companies.amazon;

import java.util.HashMap;

public class FirstUniqueCharInString {

    //https://leetcode.com/problems/first-unique-character-in-a-string/
    public static void main( String[] args ) {
        String str = "loveleetcode";
        System.out.println(firstUniqChar(str));
    }

    //solved : Runtime: 21 ms, faster than 57.00% of Java
    private static int firstUniqChar( String s ) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), -1);
            else {
                map.put(s.charAt(i), i); //inserting first occ. index.
            }
        }

        int min = Integer.MAX_VALUE;
        for (Character ch : map.keySet()) {

            if (map.get(ch) > -1 && map.get(ch) < min) {
                min = map.get(ch);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
