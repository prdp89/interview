package com.interview.companies.amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfString {

    //https://leetcode.com/problems/reverse-vowels-of-a-string/
    public static void main( String[] args ) {

        String str = "hello";

        System.out.println(reverseVowels(str));
    }

    //TIme Complexity : O (N)
    //Space: O(N)
    //Runtime: 3 ms, faster than 80.16%
    private static String reverseVowels( String s ) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('o');
        set.add('O');
        set.add('u');
        set.add('U');

        int i = 0, j = s.length() - 1;
        char[] chars = s.toCharArray();

        while (i < j) { //should go till, otherwise wrong op with last char also get replaced

            //move to right until we find a vowel
            while (i < j && !set.contains(chars[i])) {
                i++;
            }

            //right to left
            while (i < j && !set.contains(chars[j])) {
                j--;
            }

            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;

            i++;
            j--;
        }

        return Arrays.toString(chars); //this returns ['h', 'e', 'l'....]
        //return new String(chars) // this returns : "hel.."
    }
}
