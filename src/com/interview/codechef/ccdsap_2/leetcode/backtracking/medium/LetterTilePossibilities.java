package com.interview.codechef.ccdsap_2.leetcode.backtracking.medium;

import java.util.Arrays;
import java.util.HashSet;

public class LetterTilePossibilities {

    //https://leetcode.com/problems/letter-tile-possibilities/
    public static void main( String[] args ) {
        //String str = "AAB"; //op :8
        String str = "AAABBC";
        numTilePossibilities(str);
    }

    private static int numTilePossibilities( String tiles ) {

        if (tiles == null || tiles.isEmpty())
            return 0;

        HashSet<String> list = new HashSet<>();

        numTilePossibilitiesHelper(tiles.toCharArray(), 0, list);

        return list.size();
    }

    //we are generating Permutation of combination means
    // , for each length of string we are generating Permutation of String

    private static void numTilePossibilitiesHelper( char[] chars, int index, HashSet<String> list ) {

        //when we found atleast one char, add it to the HashSet
        if (index >= 1) {
            list.add(String.valueOf(Arrays.copyOf(chars, index)));
            //return; //doesn't work with return bcz it is permutation of combination.
        }

        //This logic is same as PermuationOfString
        for (int i = index; i < chars.length; i++) {
            swap(chars, i, index);

            numTilePossibilitiesHelper(chars, index + 1, list);

            swap(chars, i, index);
        }
    }

    private static void swap( char[] chars, int i, int j ) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
