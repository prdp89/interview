package com.interview.leetcode.contests._new_weekely.weekely197;

public class SubstringWithOnlyOnes {

    //https://leetcode.com/contest/weekly-contest-197/problems/number-of-substrings-with-only-1s/
    public static void main( String[] args ) {
        String s = "000";
        System.out.println(numSub(s));
    }

    //54 / 56 test cases passed.
    private static int numSub( String s ) {
        int end = 0, start = 0, res = 0;

        while (end < s.length()) {

            if (s.charAt(end) == '1') {
                start++;
            } else if (start > 0) {
                res += (start * (start + 1)) / 2;

                res %= Math.pow(10, 9) + 7;
                start = 0;
            }

            end += 1;
        }

        if (start > 0)
            res += (start * (start + 1)) / 2;

        res %= Math.pow(10, 9) + 7;

        return res;
    }

    public int numSub_without_formula( String s ) {
        int res = 0, count = 0, mod = (int) 1e9 + 7;

        //same as NumOfGoodPairs
        for (int i = 0; i < s.length(); ++i) {
            count = s.charAt(i) == '1' ? count + 1 : 0;
            res = (res + count) % mod;
        }

        return res;
    }
}
