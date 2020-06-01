package com.interview.leetcode.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PalindromePairs {

    //https://leetcode.com/problems/palindrome-pairs/
    public static void main( String[] args ) {
        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};

        palindromePairs(words).forEach(System.out::println);
    }

    //https://leetcode.com/problems/palindrome-pairs/discuss/79210/The-Easy-to-unserstand-JAVA-Solution

    //written and understood : Runtime: 724 ms, faster than 8.21% of Java
    private static List<List<Integer>> palindromePairs( String[] words ) {
        List<List<Integer>> list = new ArrayList<>();

        if (words == null || words.length == 0)
            return list;

        HashMap<String, Integer> map = new HashMap<>();
        int i = 0;
        for (String word : words) {
            map.put(word, i++);
        }

        //Step1: Method 1
        //Empty string "" can combine with any-other String if other String is palindrome
        if (map.containsKey("")) {
            int id = map.get("");

            for (int j = 0; j < words.length; j++) {

                //if second string is palindrome
                if (j != id && palindrome(words[j])) {
                    list.add(Arrays.asList(id, j));
                    list.add(Arrays.asList(j, id));
                }
            }
        }

        //Step2: Method 2
        //Reverse the existing String and check if it exist in Map
        for (int j = 0; j < words.length; j++) {
            String reverseWord = new StringBuilder(words[j]).reverse().toString();

            //if map contains reverse word and index of reverse and curr is not same.
            if (map.containsKey(reverseWord)) {
                int revIndex = map.get(reverseWord);

                if (revIndex == j)
                    continue;

                list.add(Arrays.asList(j, revIndex));
            }
        }

        //Step3: Method 3
        //case1 : s1[0:cut] is palindrome and s1[cut+1:] = reverse(s2) => (s2, s1)
        //Meaning: If First part of String is palindrome, then we'll check for reverse_of_second part of same string,
        //          If that second part exist in MAP then we found a match
        //Eg: {"lls","sssll"}
        //We are partitioning "sssll" : First part : "ss" , Second part : "sll", reverse_of_Second = "lls"
        //exist in array. We found a match.

        for (int j = 0; j < words.length; j++) {

            String currString = words[j];

            //cutting the String into parts
            for (int k = 1; k <= currString.length(); k++) {

                //if first part is palindrome
                if (palindrome(currString.substring(0, k))) {

                    //reverse the second part
                    String reverseSecondPart = new StringBuilder(currString.substring(k)).reverse().toString();

                    if (map.containsKey(reverseSecondPart)) {
                        int revIndex = map.get(reverseSecondPart);

                        if (revIndex == j)
                            continue;

                        if (!list.contains(Arrays.asList(revIndex, j)))
                            list.add(Arrays.asList(revIndex, j));
                    }
                }

                //vice versa of above if condition
                if (palindrome(currString.substring(k))) {

                    //reverse the second part
                    String reverseSecondPart = new StringBuilder(currString.substring(0, k)).reverse().toString();

                    if (map.containsKey(reverseSecondPart)) {
                        int revIndex = map.get(reverseSecondPart);

                        if (revIndex == j)
                            continue;

                        if (!list.contains(Arrays.asList(j, revIndex)))
                            list.add(Arrays.asList(j, revIndex));
                    }
                }
            }
        }

        return list;
    }

    private static boolean palindrome( String word ) {
        int i = 0, j = word.length() - 1;

        while (i <= j) {

            if (word.charAt(i) != word.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }
}
