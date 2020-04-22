package com.interview.leetcode.contests.contest140;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/contest/weekly-contest-140/problems/letter-tile-possibilities/
public class LetterTilePossibilities {

    //set retain the unique permutations of each character
    private static Set<String> set;

    public static void main( String[] args ) {
        numTilePossibilities("AAB");
    }

    private static int numTilePossibilities( String tiles ) {
        set = new HashSet<>();
        backtrack(tiles.toCharArray(), 0);
        return set.size();
    }

    private static void backtrack( char[] chars, int i ) {

        //only diff is here; In PermutationOfString we generate only Length 3;
        // but here we have to generate for each character permutation
        if (i >= 1) {
            set.add(String.valueOf(Arrays.copyOf(chars, i))); //i returns the length of chars from Chars-Array
        }

        if (i == chars.length)
            return;

        for (int j = i; j < chars.length; j++) {

            //This logic is similar to PermutationOfString
            swap(chars, i, j);

            backtrack(chars, i + 1);

            swap(chars, i, j);
        }
    }

    private static void swap( char[] chars, int i, int j ) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
