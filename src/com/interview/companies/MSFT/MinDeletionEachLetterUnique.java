package com.interview.companies.MSFT;

import java.util.*;

public class MinDeletionEachLetterUnique {

    //https://leetcode.com/discuss/interview-question/398035/

    /*
    Given a string s consisting of n lowercase letters,
    you have to delete the minimum number of characters from s so that every letter in s appears a
    unique number of times.

    We only care about the occurrences of letters that appear at least once in result.
     */

    /*
    Input: "aaa bb ff dd eee"
    Output: 6

    Explanation:
    Count frequency of each character.
    Sort by Frequency then we can easily remove character of lower frequency to get Min. deletions.
     */

    public static void main( String[] args ) {
        System.out.println(minDeletions("aabbffddeaee"));
    }

    private static int minDeletions( String str ) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++)
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);

        List<Integer> list = new ArrayList<>(map.values());

        Collections.sort(list, Collections.reverseOrder());

        HashSet<Integer> hashSet = new HashSet<>();
        int deletedChar = 0;

        //This guy logic is to keep larger frequency, so if the frequency duplicate
        //eg : 3 it reduce it to 2 then store into the HashSet.
        for (Integer item : list) {

            if (!hashSet.contains(item)) {
                hashSet.add(item);
                continue;
            }

            while (hashSet.contains(item)) {
                item--;
                deletedChar++;
            }

            if (item != 0)
                hashSet.add(item);
        }

        return deletedChar;
    }
}
