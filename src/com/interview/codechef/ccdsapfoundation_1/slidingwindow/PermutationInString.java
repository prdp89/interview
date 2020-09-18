package com.interview.codechef.ccdsapfoundation_1.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    //https://leetcode.com/problems/permutation-in-string/
    public static void main( String[] args ) {
        String s1 = "ab", s2 = "eidbaooo";

        //String s1 = "ab", s2 = "eidboaoo";

        System.out.println(checkInclusion(s1, s2));
    }

    /*How do we know string p is a permutation of string s? Easy, each character in p is in s too.

       1. So we can abstract all permutation strings of s to a map (Character -> Count). i.e. abba -> {a:2, b:2}.
       2. How do we know string s2 contains a permutation of s1? We just need to create a sliding window with length of s1
          represent by Count.
       3. If Count reaches zero, we either found solution by (end - begin + 1 == len) or
       4. We have to restore the map by moving the start pointer.
     */

    //Logic is somewaht similar to MaxConsecutiveOnesIII
    private static boolean checkInclusion( String s1, String s2 ) {
        if (s1 == null || s2 == null) {
            return false;
        }

        int len = s1.length();
        Map<Character, Integer> map = new HashMap<>();

        // construct frequency map
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //count to maintain a sliding window
        int count = map.size();
        int begin = 0;
        int end = 0;

        while (end < s2.length()) {
            char ch = s2.charAt(end);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    count--;
                }
            }

            while (count == 0) {

                //end-start+1 matches s1 length, we found s1 permutation in s2.
                if (end - begin + 1 == len) {
                    return true;
                }

                char temp = s2.charAt(begin);

                //only add character from s2 if we already have key from s1.
                //bcz we finding permutation of s1 in s2.
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                    if (map.get(temp) > 0) {
                        count++; //and doing will exit the while loop :)
                    }
                }

                begin++;
            }

            end++;
        }

        return false;
    }
}
