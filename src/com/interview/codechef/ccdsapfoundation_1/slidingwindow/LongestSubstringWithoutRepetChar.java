package com.interview.codechef.ccdsapfoundation_1.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepetChar {

    //https://leetcode.com/problems/longest-substring-without-repeating-characters/

    //Ref: https://leetcode.com/problems/minimum-window-substring/discuss/26810/Java-solution.-using-two-pointers-%2B-HashMap
    //video: https://www.youtube.com/watch?v=eS6PZLjoaq8

    public static void main( String[] args ) {
        //System.out.println(lengthOfLongestSubstringOptimized("pwwkew"));

        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    private static int lengthOfLongestSubstringOptimized( String s ) {
        int i = 0, j = 0, max = 0;

        Set<Character> set = new HashSet<>();

        while (j < s.length()) {

            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }

    private static int lengthOfLongestSubstring( String s ) {
        int[] map = new int[128];
        int counter = 0, begin = 0, end = 0, d = 0;

        while (end < s.length()) {

            //if any character repeats then only increments the counter.
            if (map[s.charAt(end++)]++ > 0)
                counter++;

            //if window contain duplicate then remove char from starting..
            while (counter > 0) {

                //this template same as MinWindowSubstring
                map[s.charAt(begin)]--;

                if (map[s.charAt(begin)] > 0)
                    counter--;

                begin++;
            }

            d = Math.max(d, end - begin); //while valid, update d
        }

        return d;
    }
}
