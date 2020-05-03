package com.interview.leetcode.thirtydaymaychallenge;

import java.util.HashMap;

public class RansomNote {

    public static void main( String[] args ) {

    }

    //in one go..
    public boolean canConstruct( String ransomNote, String magazine ) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (Character ch : magazine.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (Character ch : ransomNote.toCharArray()) {
            if (!map.containsKey(ch))
                return false;

            map.put(ch, map.get(ch) - 1);
            if (map.get(ch) == 0)
                map.remove(ch);

        }

        return true;
    }

}
