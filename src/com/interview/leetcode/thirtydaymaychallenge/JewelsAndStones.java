package com.interview.leetcode.thirtydaymaychallenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    //https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3317/
    public static void main( String[] args ) {
        HashMap<Character, Integer> map = new HashMap<>();

    }

    //in one go :D
    private static int numJewelsInStones( String J, String S ) {
        Set<Character> set = new HashSet<>();
        for (Character ch : J.toCharArray()) {
            if (!set.contains(ch))
                set.add(ch);
        }

        int count = 0;
        for (Character ch : S.toCharArray()) {
            if (set.contains(ch))
                count++;
        }

        return count;
    }
}
