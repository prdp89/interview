package com.interview.codechef.ccdsapfoundation_1.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringAtMost2DistinctChar {

    //https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/


    //similar: https://leetcode.com/problems/fruit-into-baskets/
    public static void main( String[] args ) {

    }

    //This question is almost same as 'LongestSubstringWithoutRepetChar'
    // except we are using map here same as 'LongestRepeatingCharReplacement' problem

    public int lengthOfLongestSubstringTwoDistinct( String s ) {
        Map<Character, Integer> map = new HashMap<>();

        int start = 0, end = 0, counter = 0, len = 0;

        while (end < s.length()) {
            char c = s.charAt(end);

            map.put(c, map.getOrDefault(c, 0) + 1);

            if (map.get(c) == 1)
                counter++;//new distinct char

            end++;

            while (counter > 2) { //only diff. is here, we are removing the value from map if distinct char is greater than 2

                char cTemp = s.charAt(start);

                map.put(cTemp, map.get(cTemp) - 1);

                if (map.get(cTemp) == 0) { //if char frequency reaches zero then decrement distinct char count.
                    counter--;
                }
                start++;
            }

            len = Math.max(len, end - start); //same as 'LongestRepeatingCharReplacement' problem
        }
        return len;
    }
}