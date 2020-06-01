package com.interview.leetcode.contests.contest190;

public class MaxNumOfVowels {

    public static void main( String[] args ) {
        String s = "abciiidef";
        int k = 3;

        System.out.println(maxVowels(s, k));
    }

    private static int maxVowels( String s, int k ) {

        int i = 0, j = 0, max = Integer.MIN_VALUE, total = 0;

        while (j < s.length()) {

            if (isVowel(s.charAt(j)))
                total++;

            while (j - i + 1 == k) {

                max = Math.max(max, total);

                if (i < s.length() && isVowel(s.charAt(i))) {
                    total--;
                }

                i++;
            }

            j++;
        }

        return max;
    }

    private static boolean isVowel( char ch ) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
