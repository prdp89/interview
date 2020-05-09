package com.interview.leetcode.contests.biweekly.biweekely21;

public class IncreaseDecreaseString {

    //https://leetcode.com/contest/biweekly-contest-21/problems/increasing-decreasing-string/
    public static void main( String[] args ) {
        String str = "aaaabbbbcccc";
        System.out.println(sortString(str));
    }

    //you learned how to work in nested loops.  :)
    private static String sortString( String s ) {
        int[] c = new int[26];
        for (Character ch : s.toCharArray()) {
            c[ch - 'a']++;
        }

        StringBuilder ans = new StringBuilder();
        int count = 0;

        while (count < 26) {

            for (int i = 0; i < 26; i++) {
                if (c[i] > 0) {
                    ans.append((char) (i + 97));
                    c[i]--;
                }
            }

            count = 0;
            for (int i = 25; i >= 0; i--) {
                if (c[i] > 0) {
                    ans.append((char) (i + 97));
                    c[i]--;
                } else {
                    count++; //check if all char turns zero
                }
            }
        }

        return ans.toString();
    }
}
