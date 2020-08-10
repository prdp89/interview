package com.interview.leetcode.Arrays.prefix;

import java.util.HashSet;
import java.util.Set;

public class NumOfWaysSplitString {

    //https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
    public static void main( String[] args ) {
        System.out.println(numSplits("acbadbaada"));
    }

    /*
    input = "acbadbaada"
                  " a  c  b  a  d  b  a  a  d  a "
    Pre Array  =   [1, 2, 3, 3, 4, 4, 4, 4, 4, 4]     ==>Pre_Array[pos] represent no of uniqe char til that point
    Suff Array =   [4, 4, 3, 3, 3, 3, 2, 2, 2, 1]     ==>Suff_Array[pos] represent no of uniqe char til that point count from backwords
        index       0  1  2  3  4  5  6  7  8  9

    Here Pre_Array[2] == suff_Array[3] and Pre_Array[3] == suff_Array[4]
    Hence answer would be = 2
     */
    private static int numSplits( String s ) {
        Set<Character> unique = new HashSet<>();

        int n = s.length();
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        for (int i = 0; i < n; i++) {
            unique.add(s.charAt(i));
            prefix[i] = unique.size();
        }
        unique.clear();

        for (int i = n - 1; i >= 0; i--) {
            unique.add(s.charAt(i));
            suffix[i] = unique.size();
        }

        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (prefix[i - 1] == suffix[i]) {
                ans++;
            }
        }

        return ans;
    }

}
