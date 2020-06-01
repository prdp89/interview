package com.interview.leetcode.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ImplementMagicDict {
    
    //https://leetcode.com/problems/implement-magic-dictionary/
    Map<Integer, Set<String>> map;

    //Runtime: 9 ms, faster than 98.32% of Java
    private ImplementMagicDict() {
        map = new HashMap<>();
    }

    public static void main( String[] args ) {
        ImplementMagicDict implementMagicDict = new ImplementMagicDict();

        String[] strings = {"hello", "leetcode"};

        implementMagicDict.buildDict(strings);

        System.out.println(implementMagicDict.search("hello"));
        System.out.println(implementMagicDict.search("hhllo"));
    }

    private void buildDict( String[] dict ) {
        for (String s : dict) {

            int len = s.length();

            if (!map.containsKey(len)) {
                map.put(len, new HashSet<>());
            }

            map.get(len).add(s);
        }
    }

    public boolean search( String word ) {
        int len = word.length();

        if (!map.containsKey(len)) {
            return false;
        }

        for (String s : map.get(len)) {
            int count = 0;

            for (int i = 0; i < len; i++) {
                if (word.charAt(i) != s.charAt(i)) {
                    count++;
                }

                if (count > 1)
                    break;
            }

            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}
