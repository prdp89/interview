package com.interview.companies.MSFT;

import java.util.HashSet;

public class IsPalindromePossible {

    //Given a String, check if palindrome is possible on any of its permutation..
    public static void main( String[] args ) {
        //String str = "mamad"; //true
        String str = "asflkj"; //false

        System.out.println(isPalindromePossible(str));
    }

    private static boolean isPalindromePossible( String str ) {
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {

            if (set.contains(str.charAt(i)))
                set.remove(str.charAt(i));
            else
                set.add(str.charAt(i));
        }

        return set.size() < 2;
    }
}
