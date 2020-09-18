package com.interview.leetcode.contests.contest177;

public class NumOfSubstringAllThreeChars {

    //https://leetcode.com/contest/biweekly-contest-20/problems/number-of-substrings-containing-all-three-characters/
    public static void main( String[] args ) {
        System.out.println(numberOfSubstrings("abcabc"));
    }

    private static int numberOfSubstrings( String s ) {

        int j = 0, res = 0, count[] = {0, 0, 0};

        for (int i = 0; i < s.length(); i++) {

            ++count[s.charAt(i) - 'a'];

            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {

                --count[s.charAt(j++) - 'a'];
            }

            res += j; //result should contain atleast all 3 chars string, so adding 'J'
        }
        return res;
    }
}
