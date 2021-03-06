package com.interview.codechef.ccdsap_2.leetcode.arrays.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramInString {

    //check 2nd Implementation of MinWindowSubString, will be helpful..

    //https://leetcode.com/problems/find-all-anagrams-in-a-string/
    public static void main( String[] args ) {
        findAnagrams("cbaebabacd", "abc").forEach(System.out::println);

        System.out.println("again:");
        findAnagramsAgain("cbaebabacd", "abc").forEach(System.out::println);
    }

    private static List<Integer> findAnagrams( String s, String p ) {
        List<Integer> list = new ArrayList<>();

        if (s == null || s.length() == 0 || p == null || p.length() == 0)
            return list;

        int[] hash = new int[256]; //character hash

        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }

        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right)] >= 1) {
                count--;
            }
            hash[s.charAt(right)]--;
            right++;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) {
                list.add(left);
            }

            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length()) {

                if (hash[s.charAt(left)] >= 0) {
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;

            }
        }

        return list;
    }

    //done by me...
    //Runtime: 4 ms, faster than 99.07% of Java
    //same pattern as : LongestSubstringWithoutRepetChar
    private static List<Integer> findAnagramsAgain( String s, String p ) {
        List<Integer> list = new ArrayList<>();

        if (s == null || s.length() == 0 || p == null || p.length() == 0)
            return list;

        int[] hash = new int[256]; //character hash

        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }

        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {
            if (hash[s.charAt(right++)]-- > 0) {
                count--;
            }

            while (count == 0) {

                if (right - left == p.length()) {
                    list.add(left);
                }

                hash[s.charAt(left)]++;
                if (hash[s.charAt(left)] > 0) {
                    count++;
                }

                left++;
            }
        }

        return list;
    }
}
