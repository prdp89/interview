package com.interview.hackerrank.InterviewPreprationKit;

import java.util.Arrays;
import java.util.HashMap;

public class SherlockAndAnagrams {

    //https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
    public static void main( String[] args ) {
        //solve();

        System.out.println(sherlockAndAnagrams("abba"));
    }

   /* private static void findSubsequence() {
        Scanner scanner = new Scanner(System.in);
        StringProblem input = scanner.next();

        HashMap<StringProblem, Integer> map = new HashMap<>();

        //generating a range of numbers from 0 to 2^n-1
        int range = (1 << input.length()) - 1; // where 1<<length = 1*2^n

        int totalCount = 0;

        for (int i = 0; i <= range; i++) {
            totalCount = filterChars(input, i, map, totalCount);
        }

        System.out.println(totalCount);
    }

    private static int filterChars( StringProblem a, int no, HashMap<StringProblem, Integer> map, int totalCount ) {
        //if input = abc and no = 5 then output= ac; means : 5=101 , so we pick only set bits

        StringBuilder stringBuilder = new StringBuilder();

        int i = 0;
        while (no > 0) {

            //if last bit of number is set then print the character at ith position
            if ((no & 1) > 0) {
                // System.out.print(a.charAt(i));
                stringBuilder.append(a.charAt(i));
            }

            i++;
            no = no >> 1;
        }

        StringProblem currentSubString = stringBuilder.toString();

        if (currentSubString.length() > 0) {
            // Sort all strings E.g. ab & ba both == ab now
            char[] chars = currentSubString.toCharArray();
            Arrays.sort(chars);
            currentSubString = StringProblem.valueOf(chars);

            // If sorted substring has been seen before
            if (map.containsKey(currentSubString)) {
                // Check how many times we've seen it and add that amount to the count
                int value = map.get(currentSubString);
                totalCount = totalCount + value;

                // Increment the times we've seen the string
                map.put(currentSubString, value + 1);
            } else {
                // Never seen it before = insert and set to 1 to indicate we've now seen it
                map.put(currentSubString, 1);
            }
        }

        return totalCount;
    }

    private static void solve() {
        findSubsequence();
    }*/


    //This question doesn't require generation all pairs.
    //In this we are generating consecutive pairs of string which is N^2
    //But in subsequence with bitmasking we are generating all pairs of combinations: 2 ^ N
    static int sherlockAndAnagrams( String s ) {
        HashMap<String, Integer> map = new HashMap<>();

        // Keep track of how many anagrams we've seen
        int totalCount = 0;

        // Generate all substrings (N^2)
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String currentSubString = s.substring(i, j);

                // Sort all strings E.g. ab & ba both == ab now
                char[] chars = currentSubString.toCharArray();
                Arrays.sort(chars);
                currentSubString = String.valueOf(chars);

                // If sorted substring has been seen before
                if (map.containsKey(currentSubString)) {
                    // Check how many times we've seen it and add that amount to the count
                    int value = map.get(currentSubString);
                    totalCount = totalCount + value;

                    // Increment the times we've seen the string
                    map.put(currentSubString, value + 1);
                } else {
                    // Never seen it before = insert and set to 1 to indicate we've now seen it
                    map.put(currentSubString, 1);
                }
            }
        }
        return totalCount;

    }
}
