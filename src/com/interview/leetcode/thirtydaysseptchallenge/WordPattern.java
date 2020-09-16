package com.interview.leetcode.thirtydaysseptchallenge;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    //https://leetcode.com/problems/word-pattern/
    public static void main( String[] args ) {
        String pattern = "abba";
        String s = "dog cat cat dog";

        System.out.println(wordPattern(pattern, s));
    }

    //We need to mao each pattern character with s string
    // a --> dog
    // b --> cat
    // If again B comes it should map with another "CAT in string s

    //Runtime: 1 ms, faster than 42.53% of Java
    private static boolean wordPattern( String pattern, String s ) {
        Map<Character, String> charMap = new HashMap<>();
        Map<String, Character> stringMap = new HashMap<>();

        String[] arr = s.split(" ");

        for (int i = 0; i < pattern.length(); i++) {

            //if string s exist in MAP and its value doesn't match with current char, then return false
            //map[dog] = a, if DOG iterates again and it doesn't match with 'a' --> return false
            if (stringMap.containsKey(arr[i]) && stringMap.get(arr[i]) != pattern.charAt(i) ||
                    charMap.containsKey(pattern.charAt(i)) && !charMap.get(pattern.charAt(i)).equals(arr[i])) //or vice-versa
                return false;

            charMap.put(pattern.charAt(i), arr[i]);
            stringMap.put(arr[i], pattern.charAt(i));
        }

        return true;
    }
}
