package com.interview.leetcode.nickwhite;

import java.util.HashMap;
import java.util.Map;

public class RepeatedSubstringPattern {

    //https://leetcode.com/problems/repeated-substring-pattern/
    public static void main( String[] args ) {
        System.out.println(repeatedSubstringPatternOptimal("abcabcabcabc"));
    }

    //Runtime: 15 ms, faster than 67.92% of Java
    //https://www.youtube.com/watch?v=bClIZj66dVE&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=168
    private static boolean repeatedSubstringPatternOptimal( String s ) {

        int length = s.length();

        //splitting half the string and check from that point if we can make repeated strings
        for (int i = length / 2; i > 0; i--) {

            //i divides the length means we can generate pieces now..
            if (length % i == 0) {
                int eachPieceRepeatTime = length / i;

                String subString = s.substring(0, i);

                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < eachPieceRepeatTime; j++)
                    sb.append(subString);

                if (sb.toString().equals(s))
                    return true;
            }
        }
        return false;
    }

    //61 / 120 test cases passed.
    public boolean repeatedSubstringPatternFailed( String s ) {

        if (s.length() <= 1)
            return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int count = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            if (count != 0 && count != entry.getValue())
                return false;
            else if (count == 0) {
                count = entry.getValue();
            }
        }

        return true;
    }
}
